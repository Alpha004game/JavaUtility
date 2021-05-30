package personale;


import Liste.Lista;
import Liste.Lista2;
import Liste.Nodo;

import java.io.IOException;
import java.util.Scanner;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        /*System.out.print("Inserisci il nome: ");
        String nome;
        nome= GetInputScan.getLine();
        System.out.println("il nome e': "+ nome);

        System.out.print("Inserisci il tuo numero preferito: ");
        int numPref;
        numPref= GetInput.getInt(0,100,true,true);
        System.out.println("Il tuo numero preferito è "+ numPref);

        System.out.print("Inserisci il cognome: ");
        String cognome;
        cognome= GetInputScan.getLine();
        System.out.println("il cognome e': "+ cognome);

        System.out.println(GetInput.getBoolean("Sei un bro?", "Si", "No"));
        */

        //System.out.println(GetFileSeq.writeFile("ciao", "text.txt", "w", 10));
        /*String text;
        System.out.print("Inserisci il testo da salvare: ");
        Scanner s=new Scanner(System.in);
        text=s.nextLine();

        //
        try
        {
            text="\n"+text;
            FileWriter writer=new FileWriter("prova.txt", true);
            writer.write(text);
            writer.flush();
            writer.close();
            File file =new File("prova.txt");
            Scanner read=new Scanner(file);

            String lett="", testo="";
            while(read.hasNext())
            {
                lett=read.nextLine();
                if(testo.equals(""))
                    testo+=lett;
                else
                    testo=testo+"\n"+lett;

            }
            System.out.println(testo);
        }
        catch(Exception e)
        {
            System.out.println("Errore");
        }*/

        Lista<Persona> lista=new Lista<>();

        lista.inserisciInCoda(new Persona("A", "A", 1));
        //System.out.println("a");
        lista.inserisciInCoda(new Persona("B", "B", 2));
        lista.inserisciInCoda(new Persona("C", "C", 3));

        System.out.println(lista.visita());

        Nodo tmp=lista.elimina(new Persona("A", "A", 1));


        System.out.println(tmp.getInfo().toString()+"\n");
        //System.out.println("aaaa");
        System.out.println(lista.visita());


    }
}
