package crypt;

import java.util.Locale;

public class asciiLogic {

    private static int[] key= new int[]{9, 7, 8, 6, 5, 3, 4, 2, 0, 1};

    public static int[] crypt(String msg)
    {

        //msg=msg.toUpperCase(Locale.ROOT);
        System.out.println(msg);
        char[] chararray=msg.toCharArray();
        int[] finalResult=new int[chararray.length];

        for(int i=0; i<chararray.length; i++)
        {
            int res;
            int numAscii;
            int scorrimento=0;
            numAscii=(int)chararray[i];
            res=numAscii/*-key[scorrimento]*/;
            if(scorrimento>10)
                scorrimento=0;
            finalResult[i]=res;
            scorrimento++;
        }

        return finalResult;
    }
    public static String decrypt(int[] crypted)
    {
        String finale="";
        int scorrimento=0;
        for(int i=0; i<crypted.length; i++)
        {
            finale=finale+(char)(crypted[i]+key[scorrimento]);
        }
        if(scorrimento>10)
            scorrimento=0;
        scorrimento++;

        return finale;
    }



    public static void main(String[] args)
    {
        int[] crypted=asciiLogic.crypt("ciao");
        for(int i=0; i<crypted.length; i++)
        {
            System.out.println(crypted[i]);
        }
        System.out.println(decrypt(crypted));
    }

}
