package encryption;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class DHGenerator {

    private static long[] getGNP(){
        long[] value=new long[3];
        String url="jdbc:mariadb://localhost:3306/personal";
        String user="security";
        String password="security1!";
        try
        {
            Connection connection= DriverManager.getConnection(url, user, password);
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM codes WHERE id=1");
            resultSet.next();
            value[0]=resultSet.getLong("n");
            value[1]=resultSet.getLong("g");
            value[2]=resultSet.getInt("port");
            resultSet.close();
            statement.close();
            connection.close();
            return value;
        }
        catch(Exception e)
        {
            System.out.println("Qualcosa è andato storto: "+e.getMessage());
        }

        return null;
    }

    public static BigInteger alice() throws Exception
    {
        long[] data=getGNP();
        String tmp=null;
        Random random=new Random();
        BigInteger g=new BigInteger(String.valueOf(data[0])),n=new BigInteger(String.valueOf(data[1]));
        int port=(int) data[2];
        data=null;

        ServerSocket server=new ServerSocket(port);
        Socket bob= server.accept();
        BufferedReader in=new BufferedReader(new InputStreamReader(bob.getInputStream()));
        PrintWriter out=new PrintWriter(bob.getOutputStream(), true);

        Symmetric test;
        boolean result;

        BigInteger a,ka,kb,key;
        a=new BigInteger(String.valueOf(random.nextLong())).abs();
        ka=g.modPow(a, n);



        out.println(ka.toString());
        while(tmp==null)
        {
            //System.out.println("Alice waiting 1");
            tmp=in.readLine();
        }

        kb=new BigInteger(tmp);

        key=kb.modPow(a, n);

        test=new Symmetric(key.toString());
        out.println(test.encryptAES("Lorem ipsum odor amet, consectetuer adipiscing elit."));

        tmp=null;
        while(tmp==null)
        {
            //System.out.println("Alice waiting 2");
            tmp=in.readLine();
        }
        result=test.decryptAES(tmp).equalsIgnoreCase("Placerat praesent placerat ultrices dapibus accumsan mi.");

        in.close();
        out.close();
        bob.close();
        server.close();

        if(result)
            return key;
        else
            throw new Exception("Errore nella creazione della chiave");
    }

    public static BigInteger bob(String host) throws Exception
    {
        long[] data=getGNP();
        String tmp=null;
        boolean connect=false;
        Random random=new Random();
        BigInteger g=new BigInteger(String.valueOf(data[0])),n=new BigInteger(String.valueOf(data[1]));
        int port=(int)data[2];
        data=null;

        Socket alice= new Socket();
        while(!connect)
        {
            try
            {
                alice= new Socket();
                alice.connect(new InetSocketAddress(host, port), 30000);
                connect=true;
            }
            catch(Exception e)
            {
                connect=false;
            }
        }

        BufferedReader in=new BufferedReader(new InputStreamReader(alice.getInputStream()));
        PrintWriter out=new PrintWriter(alice.getOutputStream(), true);

        Symmetric test;
        boolean result;

        BigInteger b,kb,ka,key;
        b=new BigInteger(String.valueOf(random.nextLong())).abs();
        kb=g.modPow(b, n);
        while(tmp==null)
        {
            //System.out.println("Bob waiting 1");
            tmp=in.readLine();
        }
        ka=new BigInteger(tmp);

        out.println(kb.toString());

        key=ka.modPow(b, n);

        test=new Symmetric(key.toString());

        tmp=null;
        while(tmp==null)
        {
            //System.out.println("Bob waiting 2");
            tmp=in.readLine();
        }
        if(test.decryptAES(tmp).equalsIgnoreCase("Lorem ipsum odor amet, consectetuer adipiscing elit."))
        {
            result=true;
            out.println(test.encryptAES("Placerat praesent placerat ultrices dapibus accumsan mi."));

        }
        else
            result=false;

        in.close();
        out.close();
        alice.close();

        if(result)
            return key;
        else
            throw new Exception("Errore nella generazione delle chiavi");
    }




}
