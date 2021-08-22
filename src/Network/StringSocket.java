package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StringSocket {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public StringSocket(String ip, int port)
    {

            try {
                this.client=new Socket(ip, port);
                in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);

            } catch (IOException ex) {

            }
    }
    public StringSocket(Socket socket)
    {
        client=socket;
        try
        {
            in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        }
        catch(Exception e)
        {

        }
    }

    public boolean terminate()
    {
        try
        {
            client.close();
            in.close();
            out.close();
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }
    public  boolean terminate(boolean closesocket)
    {
        if(closesocket==false)
        {
            try
            {
                in.close();
                out.close();
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        else
            return terminate();
    }

    public Socket getClient() {
        return client;
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void sendString(String msg){if(msg!=null){ out.println(msg);}}
    public String reciveString() throws IOException {return in.readLine();}

    /*public void close()
    {
        try
        {
            client.close();
            in.close();
            out.close();
        }
        catch(Exception e)
        {

        }

    }*/
}
