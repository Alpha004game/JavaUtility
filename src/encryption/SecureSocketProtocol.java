package encryption;


import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SecureSocketProtocol {

    private boolean isServer;
    private String address;
    private int port;
    private ServerSocket server;
    private Socket client;
    private BigInteger pairKey;
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public SecureSocketProtocol(String address, int port) throws Exception
    {
        this.isServer=false;
        this.address=address;
        if(port<1024 || port>49151)
            throw new Exception("Port not valid");
        this.port=port;
    }
    public SecureSocketProtocol(int port) throws Exception
    {
        this.isServer=true;
        if(port<1024 || port>49151)
            throw new Exception("Port not valid");
        this.port=port;
    }


    public void connect() throws Exception
    {
        if(isServer)
        {
            server=new ServerSocket(this.port);
            this.pairKey=DHGenerator.alice();
            KeyPair momentaneo=Asymmetric.generateRSAKeys();
            this.privateKey=momentaneo.getPrivate();
            
        }
        else
        {
            boolean connect=false;
            while(!connect)
            {
                try
                {
                    client=new Socket(this.address, this.port);
                    connect=true;
                }
                catch(Exception e)
                {
                    connect=false;
                }
                this.pairKey=DHGenerator.bob(this.address);
            }

        }
    }
}
