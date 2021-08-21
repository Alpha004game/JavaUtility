package TestPack;

import java.io.IOException;
import java.net.Socket;

import Network.FileSocket;

public class ClientFileInoltratore {

    public static void main(String[] args)
    {
        Socket socket;
        try {
           socket=new Socket("localhost", 5059);
        } catch (IOException e) {
            socket=null;
        }

        if(socket!=null)
        {
            FileSocket.sendFile(socket, "mandare.txt");
        }
    }
}
