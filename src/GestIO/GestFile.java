package GestIO;

import java.io.File;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/*
    TITOLO: GestFile
    DESCRIZIONE: classe per la gestione dei file sia testuali che binari
    AUTORE: Francesco Patti
    CLASSE E SCUOLA: 4a E inf. I.T.I. Vittorio Emanuele III
    DATA DI CREAZIONE: 09/04/2021
    ULTIMA MODIFICA:   16/04/2021
    VERSIONE: 2.5.0

*/


/*
    *Note:
    *inserire la chiusura del file --Completato 16/04/2021--
    * gestire l'append
 */

public class GestFile<T> {
    public static boolean fileExists(String path)
    {
        File  file= new File(path);
        return file.exists();
    }

    public static File copyFile(Path source, String dest)
    {

        File file=new File(dest);
        try
        {
            Files.copy(source, file.toPath());
        }
        catch(Exception e)
        {

        }

        return file;

    }

    public static void cutFile(File file, String dest)
    {
        File desti=new File(dest);
        file.renameTo(desti);
    }


    public static boolean createFile(String path)
    {
        try {
            File file = new File(path);
            if (file.createNewFile()) {
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean writeFile(String path, String text)
    {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean writeFile(String path, String text, String mod)
    {
        boolean append=false;
        if(mod.equalsIgnoreCase("a"))
            append=true;

        try {
            FileWriter fileWriter = new FileWriter(path, append);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static String readFile(String path)
    {
        String text="";
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                //System.out.println(data);
                if(text.equals(""))
                    text=text+data;
                else
                    text=text+"\n"+data;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return null;
        }
        return text;
    }

    public static String fillString(String text, int lenght)
    {
        return String.format("%-" + lenght + "s", text);
    }


    public void saveFile(Socket clientSock) throws IOException { //beta
        DataInputStream dis = new DataInputStream(clientSock.getInputStream());
        FileOutputStream fos = new FileOutputStream("testfile.jpg");
        byte[] buffer = new byte[4096];

        int filesize = 15123; // Send file size in separate msg
        int read = 0;
        int totalRead = 0;
        int remaining = filesize;
        while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
            totalRead += read;
            remaining -= read;
            System.out.println("read " + totalRead + " bytes.");
            fos.write(buffer, 0, read);
        }

        fos.close();
        dis.close();
    }

    //-------------------------------------------------------------------


    public boolean writeObject(T object, String path)
    {
        try
        {
            FileOutputStream file= new FileOutputStream(path);
            ObjectOutputStream stream= new ObjectOutputStream(file);
            stream.writeObject(object);
            stream.flush();
            file.close();
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }


    public boolean writeObjects(T[] object, String path)
    {

        try
        {
            FileOutputStream file= new FileOutputStream(path);
            ObjectOutputStream stream= new ObjectOutputStream(file);
            stream.writeObject(object);
            stream.flush();
            file.close();
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }


    public T readObject(String path)
    {
        T object;
        try
        {
            FileInputStream file= new FileInputStream(path);
            ObjectInputStream stream= new ObjectInputStream(file);
            object= (T) stream.readObject();
            file.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return object;
    }

    public T[] readObjects(String path)
    {
        FileInputStream file;
        ObjectInputStream stream;
        T[] objects;
        try
        {
            file= new FileInputStream(path);
            stream= new ObjectInputStream(file);

        }
        catch(Exception e)
        {
            return null;
        }

        try
        {
            objects= (T[]) stream.readObject();
            file.close();

        }

        catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return objects;
    }


    public boolean writeArrayList(ArrayList<T> object, String path)
    {
        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(object);
            stream.flush();
            file.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<T> readArrayList(String path)
    {
        ArrayList<T> object;
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream stream = new ObjectInputStream(file);
            object = (ArrayList<T>) stream.readObject();
            file.close();
        } catch (Exception e) {
            return null;
        }
        return object;

    }



}
