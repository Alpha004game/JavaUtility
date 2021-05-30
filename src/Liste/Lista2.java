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


}
