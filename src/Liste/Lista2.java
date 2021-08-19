package Liste;

public class Lista2<T extends Comparable<T>> {

    private Nodo head;

    public Lista2() {
        head=null;
    }

    public void inserisciInTesta(T object)
    {
        Nodo p=new Nodo(object,head);
        head=p;

    }

    public void inserisciInCoda(T object)
    {
        if(head==null)
        {
            inserisciInTesta(object);
            return;
        }


        Nodo s=head;
        while(s.getLink()!=null)
        {
            s=s.getLink();
        }
        s.setLink(new Nodo(object));
    }

    public String visita()
    {
        String msg="";
        Nodo p=head;
        if(p==null)
            return "Lista vuota";
        while(p!=null){

            msg=msg+p.getInfo().toString()+"\n";
            p=p.getLink();
        }
        return msg;

    }

    public void svuotaLista()
    {
        head=null;
    }


    public Lista2<T> copiaLista()
    {
        Lista2<T> listaCopia=new Lista2<>();
        Nodo n=head;
        while(n!=null)
        {
            listaCopia.inserisciInCoda((T)n.getInfo());

            n=n.getLink();
        }


        return listaCopia;
    }


    public int contaOggetti(T object)
    {
        Nodo n=head;
        int i=0;
        while(n!=null)
        {
            if(n.equals(object))
                i++;
            n=n.getLink();
        }
        return i;
    }

    public int lenght()
    {
        Nodo n=head;
        int i=0;
        if(head==null)
            return 0;
        while(n!=null)
        {
            i++;
            n=n.getLink();
        }
        return i;
    }
    /*
    public Nodo elimina(T oggetto){
        Nodo i=head.getLink();
        Nodo j=head;
        Nodo restituito;
        //int o=0;
        if(i.getLink()==null && i.getInfo().compareTo(oggetto)==0){
            restituito=i;
            head=null;
            return restituito;
        }
        while(i!=null){
            if(head.getInfo().compareTo(oggetto)==0){
                restituito=head;
                head=head.getLink();
                return restituito;
            }
            else if(i.getInfo().compareTo(oggetto)==0){
                restituito=i;
                j.setLink(j.getLink().getLink());
                return restituito;
            }
            j=i;
            i=i.getLink();
            //o++;
        }
        return null;
    }
    */
    public T elimina(T object)
    {
        Nodo na=head.getLink();
        Nodo n=head;

        if(head.equals(object))
        {

            head=head.getLink();
            return (T) n.getInfo();
        }

        while(na!=null)
        {
            if(na.equals(object))
            {
                n.setLink(na.getLink());

                return (T)na.getInfo();
            }
            n=na;
            na=na.getLink();
        }
        return null;
    }

    public String toString()
    {
        String msg="";
        Nodo n=head;
        if(n==null)
        {
            return "Lista vuota";
        }
        while(n!=null)
        {
            msg=msg+n.getInfo().toString()+"\n";
            n=n.getLink();
        }
        return msg;
    }


}
