package TestPack;

import Network.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import Network.FileSocket;

public class ServerFileRicevitore {

    public static void main(String[] args)
    {
        ServerSocket server;
        Socket socket;
        {
            try {
                server = new ServerSocket(5059);
                socket= server.accept();
            } catch (IOException e) {
                socket=null;
            }
            if(socket!=null)
            {
                FileSocket.reciveFile(socket, "ricevuto.txt");
            }
        }
    }
}
