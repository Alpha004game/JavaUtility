package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestClient {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public GestClient(Socket client)
    {
            this.client=client;
            try {
                this.client=client;
                in=new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new PrintWriter(client.getOutputStream(), true);

            } catch (IOException ex) {

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
}
