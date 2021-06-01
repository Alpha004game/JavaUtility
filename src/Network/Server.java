package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ServerSocket server;
    private int port;
    private ArrayList<GestClient> clienti=new ArrayList<>();

    public Server(int port)
    {
        this.port=port;

    }

    public boolean connect()
    {
        try
        {
            server = new ServerSocket(port);
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }

    public boolean closeServer()
    {
        try
        {
            server.close();
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }

    public Socket waitClient()
    {
        Socket s=null;
        try
        {
            s= server.accept();
            clienti.add(new GestClient(s));
            return s;
        }
        catch(IOException e)
        {
            return null;
        }

    }


    public boolean terminateConnection(int i) throws noClientFoundException
    {
        if(i<0 || i> clienti.size())
            throw new noClientFoundException("No client found");
        GestClient tmp=clienti.get(i);
        boolean result=tmp.terminate();
        if(result)
            clienti.remove(tmp);
        else
            return false;
        return true;
    }




}
