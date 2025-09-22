/*
    TITOLO: GetInput
    DESCRIZIONE: Permette di avere l'imput di alcuni tipi di dato semplificando ulteriormente la tenzione
    AUTORE: Francesco Patti
    CLASSE E SCUOLA: 4a E inf. I.T.I. Vittorio Emanuele III
    DATA DI CREAZIONE: 05/12/2020
    ULTIMA MODIFICA: 09/12/2020
    VERSIONE: 2.0.0

*/


package gestIO;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 */
import java.util.Scanner;



public class GetInputScan {

    private static Scanner input=new Scanner(System.in);

    public GetInputScan() {
    }

    /*public static String getLine() throws IOException
    {
        BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
        String a= consoleIn.readLine();
        return a;
    }*/

    public static int getInt()
    {
        //Scanner input;
        //input= new Scanner(System.in);
        return input.nextInt();
    }

    public static float getFloat()
    {
        //Scanner input;
        //input= new Scanner(System.in);
        return input.nextFloat();
    }

    public static double getDouble()
    {
        //Scanner input;
        //input= new Scanner(System.in);
        return input.nextDouble();
    }

    public static long getLong()
    {
        //Scanner input;
        //input= new Scanner(System.in);
        return input.nextLong();
    }

    public static String getLine()
    {
        //Scanner input;
        //input= new Scanner(System.in);
        return input.nextLine();
    }

}
