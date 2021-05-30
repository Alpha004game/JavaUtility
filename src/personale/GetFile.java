package personale;

import java.io.File;
import java.io.*;
import java.util.Scanner;

public class GetFile {


    public static boolean fileExists(String path)
    {
        File  file= new File(path);
        return file.exists();
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





}
