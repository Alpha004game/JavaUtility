package varie;


import gestIO.GetInput;

public class NoteblockCommandGenerator {

    public static void main(String[] args)
    {
        System.out.println("Ready");
        String[] ris=Generator(GetInput.getString(), true);
        for(int i=0; i<ris.length; i++)
        {
            System.out.println(ris[i]);
        }
    }

    private static String[] Generator(String type)
    {
        String[] ris=new String[25], pitch;
        pitch= new String[]{"0.5", "0.53", "0.561", "0.595", "0.63", "0.667", "0.707", "0.749", "0.794", "0.841", "0.891", "0.944", "1", "1.059", "1.122", "1.189", "1.26", "1.335", "1.414", "1.498", "1.587", "1.682", "1.782", "1.888", "2"};
        for(int i=0; i< pitch.length; i++)
        {
            ris[i]="/playsound minecraft:block.note."+type+" master @a ~ ~ ~ 100000 "+pitch[i];
        }

        return ris;
    }

    private static String[] Generator(String type, boolean shorted)
    {
        String[] ris=new String[13], pitch;
        pitch= new String[]{"0.707", "0.749", "0.794", "0.841", "0.891", "0.944", "1", "1.059", "1.122", "1.189", "1.26", "1.335", "1.414"};
        for(int i=0; i< pitch.length; i++)
        {
            ris[i]="/playsound minecraft:block.note."+type+" master @a ~ ~ ~ 100000 "+pitch[i];
        }

        return ris;
    }

}
