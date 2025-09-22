package testPack;

import liste.Lista2;

public class TestClone {

    public static void main(String[] args)
    {
        Lista2<String> lista=new Lista2<>();

        lista.inserisciInCoda("Ciao1");
        lista.inserisciInCoda("bella");
        lista.inserisciInCoda("Ciao");
        lista.inserisciInCoda("Ciao");

        System.out.println(lista.lenght());


    }
}
