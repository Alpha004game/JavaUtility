package encryption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ServerValueGenerator {

    private long epoch;
    private long changeTime;

    private Thread updater=new Thread(this::updateValues);
    private Thread command=new Thread(this::command);
    private boolean stop=false;
    private static Random random=new Random();

    private String url="jdbc:mariadb://localhost:3306/personal";
    private String user="security";
    private String password="security1!";


    private ArrayList<String> commandQueue=new ArrayList<>();
    private static long generateChangeTime()
    {
        return random.nextInt(23)*3600000;
    }
    private ServerValueGenerator()
    {
        this.epoch=System.currentTimeMillis();
        this.changeTime=generateChangeTime();
        forceUpdate();
    }

    public void run()
    {
        int a=0;
        updater.run();
        //command.run();
        while(!stop)
        {
            a++;
        }
    }

    private void command()
    {
        Scanner scanner=new Scanner(System.in);
        while(!stop)
        {

        }
    }

    private void forceUpdate()
    {
        this.epoch=System.currentTimeMillis();
        this.changeTime=generateChangeTime();

        long n=this.epoch;
        long g=this.epoch-(random.nextInt(50)*1000000);

        sqlUpdate(n,g);
    }
    private void updateValues()
    {
        while(!stop)
        {
            if(System.currentTimeMillis()==epoch+changeTime)
            {
                this.epoch=System.currentTimeMillis();
                this.changeTime=generateChangeTime();

                long n=this.epoch;
                long g=this.epoch-(random.nextInt(50)*1000000);

                sqlUpdate(n,g);
            }
        }
    }

    private void sqlUpdate(long n, long g)
    {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try
        {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            String sql="UPDATE codes set n=?, g=? WHERE id=1";
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setLong(1, n);
            preparedStatement.setLong(2, g);
            int rows=preparedStatement.executeUpdate();
            if(rows==1)
                System.out.println("Operazione completata con successo");
            else
                System.out.println("Qualcosa è andato storto!");
        }
        catch(Exception e)
        {
            System.out.println("Eccezione rilevata: "+e.getMessage());
        }
        finally {
            try
            {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            }
            catch(Exception f)
            {
                System.out.println("Errore generico nella chiusura: "+f.getMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        ServerValueGenerator server=new ServerValueGenerator();
    }
}
