package personale;
/*
    TITOLO: GetObject
    DESCRIZIONE: Classe per la gestione del salvataggio di uno o più oggetti su file
    AUTORE: Francesco Patti
    CLASSE E SCUOLA: 4a E inf. I.T.I. Vittorio Emanuele III
    DATA DI CREAZIONE: 09/04/2021
    ULTIMA MODIFICA: 09/04/2021
    VERSIONE: 2.3.5

*/


import java.io.*;

public class GetObject<T> {

    public GetObject(){}

    public boolean writeObject(T object, String path, String mod)
    {
        boolean append=false;
        if(mod.equalsIgnoreCase("a"))
            append=true;
        try
        {
            FileOutputStream file= new FileOutputStream(path, append);
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


    public boolean writeObjects(T[] object, String path, String mod)
    {
        boolean append=false;
        if(mod.equalsIgnoreCase("a"))
            append=true;
        try
        {
            FileOutputStream file= new FileOutputStream(path, append);
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


    public Object readObject(String path)
    {
        T object=null;
        try
        {
            FileInputStream file= new FileInputStream(path);
            ObjectInputStream stream= new ObjectInputStream(file);
            return stream.readObject();
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public T[] readMultipleObject(String path)
    {
        FileInputStream file;
        ObjectInputStream stream;
        T[] objects=null;
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
            return (T[]) stream.readObject();

        }

        catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

}

