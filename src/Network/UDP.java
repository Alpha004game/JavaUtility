package Network;

import java.io.IOException;
import java.net.*;

public class UDP {
    private DatagramSocket socket;
    private byte[] buffer= new byte[1024];
    private int port;

    public UDP(int port) {
        this.port = port;
    }

    public boolean createSocket()
    {
        try {
            socket=new DatagramSocket(port);
            return true;
        } catch (SocketException e) {
            return false;
        }
    }

    public void changeBufferSize(int dim)
    {
        buffer=new byte[dim];
    }

    public boolean changePort(int port)
    {
        this.port=port;
        try {
            socket=new DatagramSocket(port);
            return true;
        } catch (SocketException e) {
            return false;
        }
    }


    public String riceviString()
    {

        try {
            String msg;
            DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
            socket.receive(packet);
            msg=new String(packet.getData());
            msg=msg.substring(0, packet.getLength());
            //System.out.println(msg);
            return msg;
        } catch (IOException e) {
            return null;
        }

    }

    public byte[] riceviByte()
    {
        DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
        try {
            socket.receive(packet);
            return packet.getData();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean sendString(String msg, String address)
    {
        InetAddress addressIA= null;
        try {
            addressIA = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            return false;
        }
        byte[] buffer;
        buffer=msg.getBytes();
        DatagramPacket packet=new DatagramPacket(buffer, buffer.length, addressIA, port);
        try {
            socket.send(packet);
            return true;
        } catch (IOException e) {
            return false;
        }

    }


    public boolean sendByte(byte[] bytes, String address)
    {
        InetAddress addressIA= null;
        try {
            addressIA = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            return false;
        }
        DatagramPacket packet=new DatagramPacket(bytes, bytes.length, addressIA, port);
        try {
            socket.send(packet);
            return true;
        } catch (IOException e) {
            return false;
        }

    }


    public void close()
    {
        socket.close();
    }
}
