package Network;

import java.io.*;
import java.net.Socket;

public class FileSocket {


    public static void sendFile(Socket socket, String path)
    {
        File file=new File(path);
        FileInputStream fis;
        BufferedInputStream bis;
        OutputStream os;
        byte[] fileByte=new byte[(int)file.length()];
        try {
            fis=new FileInputStream(file);
            bis=new BufferedInputStream(fis);
            bis.read(fileByte, 0, fileByte.length);
            os=socket.getOutputStream();
            os.write(fileByte,0, fileByte.length);
            os.flush();


            fis.close();
            bis.close();
            os.close();
            file=null;
            fis=null;
            bis=null;
            os=null;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static File reciveFile(Socket socket, String destinationPath)
    {
        int bytesRead;
        int current = 0;
        final int FILE_SIZE=6022386;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {


            // receive file
            byte [] mybytearray  = new byte [FILE_SIZE];
            InputStream is = socket.getInputStream();
            fos = new FileOutputStream(destinationPath);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray,0,mybytearray.length);
            current = bytesRead;

            do {
                bytesRead =
                        is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >= 0) current += bytesRead;
            } while(bytesRead > -1);

            bos.write(mybytearray, 0 , current);
            bos.flush();
            //System.out.println("File " + destinationPath
            //       + " downloaded (" + current + " bytes read)");
            fos.close();
            bos.close();
            return new File(destinationPath);
        }
        catch(Exception e) {
        }
        return null;
    }

}
