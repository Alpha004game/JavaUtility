package AlberoBinario;

public class Albero <T extends Comparable<T>> {
    private Nodo<T> root;

    public Albero() {
        root=null;
    }


    private void inserisci(Nodo n, Nodo p)
    {
        if(n.getInfo().compareTo(p.getInfo()) < 0)
        {
            if(p.getLinkSX() == null)
                p.setLinkSX(n);
            else
                inserisci(n, p.getLinkSX());
        }
        else if(n.getInfo().compareTo(p.getInfo()) > 0)
        {
            if(p.getLinkDX() == null)
                p.setLinkDX(n);
            else
                inserisci(n, p.getLinkDX());
        }

    }

    public void inserisci(T info)
    {
        Nodo n=new Nodo(info);
        if(root==null)
            root=n;
        else
            inserisci(n, root);
    }

    //----------------------------------Anticipata: C, S, D
    private String vistaAnticipata(Nodo p)
    {
        String contenuto="";
        if(p==null)
            return "Albero vuoto";
        contenuto=contenuto+p.getInfo().toString()+"\n";
        if(p.getLinkSX() !=null)
            contenuto=contenuto+vistaAnticipata(p.getLinkSX());
        if(p.getLinkDX() != null)
            contenuto=contenuto+vistaAnticipata(p.getLinkDX());

        return contenuto;
    }


    public String vistaAnticipata()
    {
        return vistaAnticipata(root);
    }
    //----------------------------------Simmetrica: S, C, D
    private String vistaSimmetrica(Nodo p)
    {
        String contenuto="";
        if(p==null)
            return "Albero vuoto";
        if(p.getLinkSX() != null)
            contenuto=contenuto+vistaSimmetrica(p.getLinkSX());
        contenuto=contenuto+p.getInfo().toString()+"\n";
        if(p.getLinkDX() !=null)
            contenuto=contenuto+vistaSimmetrica(p.getLinkDX());
        return contenuto;
    }
    public String vistaSimmetrica()
    {
        return vistaSimmetrica(root);
    }
    //----------------------------------Differita: S, D, C


    private String vistaDifferita(Nodo p)
    {
        String contenuto="";
        if(p==null)
            return "Lista vuota";
        if(p.getLinkSX() !=null)
            contenuto=contenuto+vistaDifferita(p.getLinkSX());
        if(p.getLinkDX() != null)
            contenuto=contenuto+vistaDifferita(p.getLinkDX());
        contenuto=contenuto+p.getInfo().toString()+"\n";

        return contenuto;
    }

    public String vistaDifferita()
    {
        return vistaDifferita(root);
    }



    //---------------------------------Ricerca nodo

    private T ricerca(Nodo p, T info)
    {
        if(p==null)
            return null;
        if(p.getLinkSX()!=null && ricerca(p.getLinkSX(), info).equals(info))
            return (T) p.getLinkSX().getInfo();
        if(p.getLinkDX()!=null && ricerca(p.getLinkDX(), info).equals(info))
            return (T) p.getLinkSX().getInfo();
        if(p.getInfo().equals(info))
            return (T) p.getInfo();
        return info;


    }

    public T ricerca(T info)
    {
        return ricerca(root, info);
    }

    public Nodo<T> getRoot() {
        return root;
    }


}
