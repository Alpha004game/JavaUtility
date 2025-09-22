package doppiamentePuntate;

/*
    TITOLO: Lista
    DESCRIZIONE: classe per la gestione generica delle liste
    AUTORE: Francesco Patti e Luciano Allegra
    CLASSE E SCUOLA: 4a E inf. I.T.I. Vittorio Emanuele III
    DATA DI CREAZIONE: 17/04/2021
    ULTIMA MODIFICA:  04/05/2021
    VERSIONE: 4.0.0

*/

public class Lista<T extends Comparable> {
    private Nodo head;
    private Nodo tail;
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

    private Nodo getSuccessivoPosizione(int posizione) throws ListaException
    {
        int n=1;
        Nodo p= head;
        if(head==null)
            throw new ListaException("Lista vuota");
        if((posizione>elementi) || (posizione<1))
            throw new ListaException("Posizione errata");
        while((p.getSuccessivo()!=null) && (n<posizione)){
            p=p.getSuccessivo();
            n++;
        }
        return p;
    }

    private Nodo creaNodo(T veivolo, Nodo link, Nodo precedente)
    {
        Nodo nuovoNodo=new Nodo();
        nuovoNodo.setInfo(veivolo);
        nuovoNodo.setSuccessivo(link);
        nuovoNodo.setPrecedente(precedente);
        return nuovoNodo;
    }

    public void inserisciInTesta(T veivolo)
    {
        Nodo p=creaNodo(veivolo,head, null);
        head=p;
        if(tail==null)
            tail=head;
        elementi++;
    }

    public void inserisciInCoda(T veivolo)
    {
        if(head==null)
            inserisciInTesta(veivolo);
        else
        {
            tail.setSuccessivo(creaNodo(veivolo, null,tail));
            tail=tail.getSuccessivo();
        }
        elementi++;
    }

    public void inserisciInPosizione(T veivolo, int posizione) throws ListaException
    {
        Nodo tmp=creaNodo(veivolo, null, null);
        if(posizione<=1)
            inserisciInTesta(veivolo);
        else{
            if(elementi<posizione)
                inserisciInCoda(veivolo);
            else
            {
                Nodo p=getSuccessivoPosizione(posizione);

                tmp.setSuccessivo(p);
                tmp.setPrecedente((p.getPrecedente()));
                p.getPrecedente().setSuccessivo(tmp);
                p.setPrecedente(tmp);

                elementi++;
            }
        }
    }

    public String visita()
    {
        String msg="";
        Nodo p=head;
        while(p!=null){
            msg=msg+p.getInfo().toString()+"\n";
            p=p.getSuccessivo();
        }
        return msg;

    }

    public String vistaReverse()
    {
        String msg="";
        Nodo p=tail;
        while(p!=null)
        {
            msg=msg+p.getInfo().toString()+"\n";
            p=p.getPrecedente();
        }
        return msg;
    }



    /*public void visitaLista()
    {


    if(p==null)
            return "";
        return p.getInfo().toString()+"\n"+visita(p.getSuccessivo());
    }*/


    /*private void inserisciInOrdine(Nodo nuovo)
    {
        T t = null;
        if(nuovo==null || nuovo.getSuccessivo()==null)
            return;
        if(head == null || head.compareTo(nuovo)>=0){
            t =(T) nuovo.getInfo();
            inserisciInTesta(t);
        }
        else{
            Nodo p=head;
            while(p.compareTo(nuovo)<0 && p.getSuccessivo()!=null && p.getSuccessivo().compareTo(nuovo)<0){
                p=p.getSuccessivo();
            }
            nuovo.setSuccessivo(p.getSuccessivo());
            p.setSuccessivo(nuovo);
            elementi++;
        }
    }*/





    /*public void ordinaLista()
    {
        Nodo tempNodo=head, tmp=tempNodo;
        Lista tempLista= new Lista();
        int i=0;
        while(tempNodo.getSuccessivo()!=null || i<elementi) //i<elementi è una condizione d'emergenza in caso per evitare il crash
        {
            tempLista.inserisciInOrdine(tempNodo);
            tempNodo=tempNodo.getSuccessivo();
            i++;
            if(tempNodo==null)
                break;
            System.out.println(i);
        }
        //tempLista.inserisciInOrdine(tempNodo); //istruzione fondamentale per non perdere un elemento
        this.head=tempLista.getHead();

    }*/

    /*
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
                tmp=tmp.getSuccessivo();
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
        b=a.getSuccessivo();
        c=b.getSuccessivo();

        a.setSuccessivo(c);
        b.setSuccessivo(c.getSuccessivo());
        c.setSuccessivo(b);
    }*/

}