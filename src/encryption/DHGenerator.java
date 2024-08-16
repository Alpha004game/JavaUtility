package encryption;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class DHGenerator {

    private static long[] getGN(){
        long[] value=new long[2];
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

    public static long alice()
    {
        long[] data=getGN();
        long g=data[1];
        long n=data[0];
        data=null;

        try
        {
            long a;
            ServerSocket server=new ServerSocket(1443);
            Socket bob= server.accept();
            BufferedReader in=new BufferedReader(new InputStreamReader(bob.getInputStream()));
            PrintWriter out=new PrintWriter(bob.getOutputStream(), true);
            Random random=new Random();
            a=random.nextLong();
            out.println(a);
            long b=Long.getLong(in.readLine());

            return (long) (Math.pow(g, a*b)%n);

        }
        catch(Exception e)
        {
            System.out.println("Problema trovato: "+e.getMessage());
        }

        return -1;
    }

    public static long bob()
    {
        return 0;
    }




}
