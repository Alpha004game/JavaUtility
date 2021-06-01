package personale;


import Liste.Lista;
import Liste.Lista2;
import Liste.Nodo;
import Sort.QuickSort;

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
        /*
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
        */

        QuickSort<Persona> sort=new QuickSort<>();
        Persona[] array=new Persona[10];
        //3,1,4,2,5,7,8,6,9,0
        array[0]=new Persona("A","A", 3);
        array[1]=new Persona("A","A", 1);
        array[2]=new Persona("A","A", 4);
        array[3]=new Persona("A","A", 2);
        array[4]=new Persona("A","A", 5);
        array[5]=new Persona("A","A", 7);
        array[6]=new Persona("A","A", 8);
        array[7]=new Persona("A","A", 6);
        array[8]=new Persona("A","A", 9);
        array[9]=new Persona("A","A", 0);
        System.out.println("Pre sort...");
        for(int i=0; i< array.length; i++)
        {
            System.out.println(array[i].toString());
        }
        sort.quickSort(array, 0, array.length-1);
        System.out.println("After sort...");
        for(int i=0; i< array.length; i++)
        {
            System.out.println(array[i].toString());
        }
    }
}
