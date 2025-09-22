package alberoBinario;


public class Nodo <T extends Comparable<T>>{

    Nodo LinkSX;
    T info;
    Nodo LinkDX;

    public Nodo(T info) {
        this.info = info;
        LinkSX=null;
        LinkDX=null;
    }

    public Nodo getLinkSX() {
        return LinkSX;
    }

    public void setLinkSX(Nodo LinkSX) {
        this.LinkSX = LinkSX;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getLinkDX() {
        return LinkDX;
    }

    public void setLinkDX(Nodo LinkDX) {
        this.LinkDX = LinkDX;
    }

    public int compareTo(Nodo<T>  n)
    {
        return info.compareTo(n.getInfo());
    }







}
