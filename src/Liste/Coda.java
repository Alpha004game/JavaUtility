package Liste;

public class Coda<T extends Comparable<T>> {

    private Lista<T> lista;

    public Coda() {
        lista=new Lista();
    }

    public void push(T object)
    {
        lista.inserisciInCoda(object);
    }

    public T pop()
    {
        T object=null;
        Nodo head;
        head=lista.getHead();

        object= (T) lista.getHead().getInfo();
        lista.setHead(lista.getHead().getLink());


        return object;
    }

    public void ordina()
    {
        lista.ordinaLista();
    }

    public String vedi()
    {
        return lista.visita();
    }



}