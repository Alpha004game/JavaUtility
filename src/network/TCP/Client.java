package network.TCP;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private String address;
    private int port;
    //private BufferedReader in;
    private OutputStream out;
    private InputStream in;
    //private PrintWriter out;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public boolean connect()
    {
        try
        {
            socket=new Socket(address, port);
            //in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //out = new PrintWriter(socket.getOutputStream(), true);
            out=socket.getOutputStream();
            in=socket.getInputStream();
            return true;

        }
        catch(Exception e)
        {
            return false;
        }
    }

    public void sendBytes(byte[] bytes) throws IOException {
        out.write(bytes);
        out.flush();
    }

    public void sendString(String msg)
    {
        PrintWriter tmp= new PrintWriter(out, true);
        tmp.write(msg);
        tmp.flush();
        tmp.close();
    }

    public byte[] reciveBytes()
    {
        try {
            return in.readAllBytes();
        } catch (IOException e) {
            return null;
        }
    }

    public String reciveString()
    {
        BufferedReader tmp=new BufferedReader(new InputStreamReader(in));
        try {
            return tmp.readLine();
        } catch (IOException e) {
            return null;
        }
    }



}
