package Network;

import java.io.IOException;
import java.net.Socket;

public class Client {


    private GestClient client;
    private String destination;
    private int port;

    public Client(String destination, int port)
    {
        this.destination=destination;
        this.port=port;
    }

    public boolean connect()
    {
        Socket s=null;
        //long timeOut;
        while(s==null/* && timeOut<*/)
        {
            try
            {
                s=new Socket(destination, port);
                client=new GestClient(s);
                return true;
            }
            catch(IOException e)
            {
                s=null;
                return false;
            }
        }
        return true;
    }

    public boolean disconnect()
    {
        boolean tmp= client.terminate();
        if(tmp)
            client=null;
        return tmp;

    }

    public void writeString(String msg)
    {
        client.getOut().println(msg);
    }
    public String reciveString()
    {
        String msg=null;
        try
        {
            msg= client.getIn().readLine();

        }
        catch(IOException e)
        {

        }
        return msg;

    }

}
