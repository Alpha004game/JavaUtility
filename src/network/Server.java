package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/*
    IMPLEMENTAZIONI DA FARE:
    -Scrivere e leggere da un certo client
    -Scrivere Broadcast per scrittura

 */
public class Server {

    private ServerSocket server;
    private int port;
    private ArrayList<GestClient> clienti=new ArrayList<>();

    public Server(int port)
    {
        this.port=port;

    }

    public boolean startServer()
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

    public void sendToClient(String msg, int i) throws noClientFoundException
    {
        if(i<0 || i> clienti.size())
            throw new noClientFoundException("No client found");
        GestClient tmp=clienti.get(i);

        tmp.getOut().println(msg);
    }

    public void sendToBroadcast(String msg)
    {
        Iterator<GestClient> i = clienti.iterator();
        while(i.hasNext())
        {
            i.next().getOut().println(msg);
        }
    }
    public String readToClient(int i) throws noClientFoundException
    {
        if(i<0 || i> clienti.size())
            throw new noClientFoundException("No client found");
        try
        {
            String msg = clienti.get(i).getIn().readLine();
            return msg;
        }
        catch(IOException e)
        {
            return "Eccezione";
        }

    }




}
