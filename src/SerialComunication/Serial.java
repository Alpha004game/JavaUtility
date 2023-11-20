package SerialComunication;
/*import com.fazecast.jSerialComm.SerialPort;
import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Serial {
    private SerialPort seriale;


    public Serial(String port) throws Exception {
        if(!existingCOM(port))
            throw new Exception("No port found");
        seriale=SerialPort.getCommPort(port);
        seriale.setComPortParameters(9600, 8, 1, 0);
        seriale.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
    }

    public Serial(String port, int rate, int data, int stop, int parity) throws Exception
    {
        if(!existingCOM(port))
            throw new Exception("No port found");
        seriale=SerialPort.getCommPort(port);
        seriale.setComPortParameters(rate, data, stop, parity);
        seriale.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
    }
    
    private boolean existingCOM(String user)
    {
        SerialPort[] serialPorts=SerialPort.getCommPorts();
        for(int i=0; i< serialPorts.length; i++)
        {
            if(user.equalsIgnoreCase(serialPorts[i].getSystemPortName()))
                return true; 
        }
        return false;

    }

    public boolean openSerial()
    {
        boolean s1=seriale.setDTR();
        boolean s2=seriale.setRTS(); //consigliato dal forum di arduino
        if(s1==true && s2==true)
            return seriale.openPort();
        else
            return false;

    }

    public boolean closeSerial()
    {
        return seriale.closePort();
    }

    public void writeString(String msg)
    {

        PrintWriter writer=new PrintWriter(seriale.getOutputStream());
        writer.write(msg);
        writer.close();

    }

    public String readString()
    {
        Scanner s=new Scanner(seriale.getInputStream());
        return s.nextLine();
    }

    public String readString(boolean manually) throws Exception {
        if(manually==false)
            return this.readString();
        else
        {
            throw new Exception("Not implemented yet");
        }

    }

   /* private void start() throws IOException {
            SerialPort[] serialPorts=SerialPort.getCommPorts();
            for(int i=0; i< serialPorts.length; i++)
            {
                System.out.println(serialPorts[i].getSystemPortName());
            }


            seriale=SerialPort.getCommPort(serialPorts[0].getSystemPortName());
            seriale.setComPortParameters(9600, 8, 1, 0);
            seriale.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
            if(seriale.openPort())
            {
                /*Thread thread=new Thread(this::send);
                thread.start();

                Integer i=1;
                seriale.getOutputStream().write(i.byteValue());
                seriale.getOutputStream().flush();
                seriale.clearDTR();
                System.out.println(seriale.getDTR());
            }
            else
                System.out.println("Cannot open port");
        }

        private void send()
        {
            PrintWriter writer=new PrintWriter(seriale.getOutputStream());
            Integer i=1;
            writer.print(i.byteValue());
            writer.flush();
            seriale.closePort();
            writer.close();
            System.out.println("message sent");
        }

        public String getMSG(String port)
        {
            byte[] stream=new byte[1024];
            seriale=SerialPort.getCommPort(port);
            seriale.setComPortParameters(9600, 8, 1, 0);
            seriale.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
            if(seriale.openPort())
            {
                //Scanner scanner=new Scanner(seriale.getInputStream());
                try {
                    seriale.getInputStream().read(stream);
                    String msg=new String(stream);
                    System.out.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println(scanner.nextLine());
            }
            return null;
        }
    */
/*
}
*/