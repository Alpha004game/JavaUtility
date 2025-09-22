package gestIO;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GetInput {
    private static InputStreamReader input = new InputStreamReader(System.in);
    private static BufferedReader tastiera= new BufferedReader(input);

    public static double getDouble()
    {
        String arg="";
        Double val=0.;
        boolean error=false;
        do {
            try
            {
                arg= tastiera.readLine();
                val= Double.valueOf(arg).doubleValue();
                error=false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Errore di formato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            } catch (IOException i){
                System.out.println("Valore errato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            }

        }
        while(error==true);
        return val;

    }


    public static double getDouble(double min, double max, boolean minyes, boolean maxyes)
    {
        String arg="";
        double val=0.;
        boolean error=false;
        do
        {
            try
            {
                arg= tastiera.readLine();
                val= Double.valueOf(arg).doubleValue();
                error=false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Errore di formato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            } catch (IOException i){
                System.out.println("Valore errato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            }


            if((minyes==true && val<min) || (val> max && maxyes==true))
            {
                if(maxyes==false)
                {
                    System.out.println("Il valore non è pari o superiore di "+ min);
                }
                else if(minyes==false)
                {
                    System.out.println("Il valore non è pari o inferiore di "+ max);
                }
                else
                    System.out.println("Il valore non rientre nell'intervallo tra: "+min+" e "+ max);
                System.out.print("Reinserisci il valore: ");
            }


        }
        while((minyes==true && val<min) || (val> max && maxyes==true) || error==true);


        return val;
    }


    public static int getInt()
    {
        String arg="";
        int a=0;
        boolean error=false;
        do {
            try
            {
                arg= tastiera.readLine();
                a= Integer.valueOf(arg).intValue();
                error=false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Errore di formato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            } catch (IOException i){
                System.out.println("Valore errato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            }

        }while(error==true);


        return a;
    }

    public static int getInt(int min, int max, boolean minyes, boolean maxyes)
    {
        String arg="";
        int val=0;
        boolean error=false;
        do
        {
            try
            {
                error=false;
                arg= tastiera.readLine();
                val= Integer.valueOf(arg).intValue();
            }
            catch(NumberFormatException e)
            {
                System.out.println("Errore di formato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            } catch (IOException i){
                System.out.println("Valore errato!");
                System.out.print("Reinserisci il valore: ");
                error=true;

            }


            if((minyes==true && val<min) || (val> max && maxyes==true))
            {
                if(maxyes==false)
                {
                    System.out.println("Il valore non è pari o superiore di "+ min);
                }
                else if(minyes==false)
                {
                    System.out.println("Il valore non è pari o inferiore di "+ max);
                }
                else
                    System.out.println("Il valore non rientre nell'intervallo tra: "+min+" e "+ max);
                System.out.print("Reinserisci il valore: ");
            }

        }
        while((minyes==true && val<min) || (val> max && maxyes==true) || error==true);

        return val;
    }


    public static String getString()
    {
        String arg="";
        boolean error=false;
        do {
            try
            {
                arg= tastiera.readLine();
            }
            catch (Exception e)
            {
                System.out.println("Errore nella lettura della stringa!");
                error=true;
                System.out.print("Reinserisci il valore: ");

            }


        }while(error==true);

        return arg;
    }


    public static boolean getBoolean(String domanda, String yes, String no)
    {
        boolean error=false, status=false;
        String get="";
        do {
            error=false;
            System.out.print(domanda+" ("+yes+"/"+no+"): ");
            try
            {
                get=tastiera.readLine();
            }
            catch (Exception e)
            {
                System.out.println("Errore nella lettura della riposta!");
                error=true;
                System.out.print("Reinserisci il valore: ");

            }
            if(get.equalsIgnoreCase(yes))
                status=true;
            else if(get.equalsIgnoreCase(no))
                status=false;
            else
            {
                System.out.println("Errore Risposta non valida!");
                error=true;
                System.out.print("Reinserisci il valore: ");

            }

        }
        while(error==true);
        return status;
    }


}
