package Liste;

public class Lista<T extends Comparable> {
    private Nodo head;
    private int elementi;

    public Lista(){
        head=null;
        elementi=0;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head)
    {
        this.head = head;
    }

    public int getElementi() {
        return elementi;
    }

    /*public void setElementi(int elementi) 
    {
        this.elementi = elementi;
    }*/

    public Nodo getLinkPosizione(int posizione) throws ListaException
    {
        int n=1;
        Nodo p= head;
        if(head==null)
            throw new ListaException("Lista vuota");
        if((posizione>elementi) || (posizione<1))
            throw new ListaException("Posizione errata");
        while((p.getLink()!=null) && (n<posizione)){
            p=p.getLink();
            n++;
        }
        return p;
    }

    private Nodo creaNodo(T veivolo, Nodo link)
    {
        Nodo nuovoNodo=new Nodo();
        nuovoNodo.setInfo(veivolo);
        nuovoNodo.setLink(link);
        return nuovoNodo;
    }

    public void inserisciInTesta(T veivolo)
    {
        Nodo p=creaNodo(veivolo,head);
        head=p;
        elementi++;
    }

    public void inserisciInCoda(T veivolo)
    {
        if(head==null)
            inserisciInTesta(veivolo);
        else{
            try{
                Nodo p=getLinkPosizione(elementi);
                p.setLink(creaNodo(veivolo,null));
                elementi++;
            }
            catch(ListaException e){

            }
        }
    }

    public void inserisciInPosizione(T veivolo, int posizione) throws ListaException
    {
        if(posizione<=1)
            inserisciInTesta(veivolo);
        else{
            if(elementi<posizione)
                inserisciInCoda(veivolo);
            else{
                Nodo p=getLinkPosizione(posizione-1);
                p.setLink(creaNodo(veivolo,p.getLink()));
                elementi++;
            }
        }
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


    /*public void visitaLista()
    {
        
    
    if(p==null)
            return "";
        return p.getInfo().toString()+"\n"+visita(p.getLink());
    }*/


    private void inserisciInOrdine(Nodo nuovo)
    {
        T t = null;
        if(nuovo==null || nuovo.getLink()==null)
            return;
        if(head == null || head.compareTo(nuovo)>=0){
            t =(T) nuovo.getInfo();
            inserisciInTesta(t);
        }
        else{
            Nodo p=head;
            while(p.compareTo(nuovo)<0 && p.getLink()!=null && p.getLink().compareTo(nuovo)<0){
                p=p.getLink();
            }
            nuovo.setLink(p.getLink());
            p.setLink(nuovo);
            elementi++;
        }
    }
    
    
    
    
    
    /*public void ordinaLista()
    {
        Nodo tempNodo=head, tmp=tempNodo;
        Lista tempLista= new Lista();
        int i=0;
        while(tempNodo.getLink()!=null || i<elementi) //i<elementi è una condizione d'emergenza in caso per evitare il crash
        {
            tempLista.inserisciInOrdine(tempNodo);
            tempNodo=tempNodo.getLink();
            i++;
            if(tempNodo==null)
                break;
            System.out.println(i);
        }
        //tempLista.inserisciInOrdine(tempNodo); //istruzione fondamentale per non perdere un elemento
        this.head=tempLista.getHead();
        
    }*/


    public void ordinaLista()
    {
        T t =null;
        this.inserisciInCoda(t);
        Nodo[] nodi= new Nodo[this.elementi];
        Nodo tmp=head;
        Lista tempLista= new Lista();
        int j=0;
        for(j=0; j<nodi.length; j++)
        {
            nodi[j]=tmp;

            if(tmp!=null)
                tmp=tmp.getLink();
        }
        for(int i=0; i<j; i++)
        {

            tempLista.inserisciInOrdine(nodi[i]);

        }
        this.head=tempLista.getHead();
    }

    public void ordinaListaV2(){
        Nodo a, b, c, tmp=new Nodo();
        a=head;
        b=a.getLink();
        c=b.getLink();

        a.setLink(c);
        b.setLink(c.getLink());
        c.setLink(b);
    }

}