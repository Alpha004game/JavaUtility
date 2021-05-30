package Liste;

public class Nodo<T extends Comparable<T>> {

    private T info;
    private Nodo link;

    public Nodo(T persona) {
        this.info = persona;
        this.link=null;
    }

    public Nodo(T object, Nodo link)
    {
        this.info=object;
        this.link=link;
    }

    public Nodo()
    {
        this.info=null;
        this.link=null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    public int compareTo(Nodo<T> nodo)
    {
        return this.info.compareTo(nodo.getInfo());
    }




}
