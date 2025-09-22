package doppiamentePuntate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francesco
 */
public class Nodo<T extends Comparable<T>> {

    private T info;
    private Nodo successivo;
    private Nodo precedente;

    public Nodo(T persona) {
        this.info = persona;
        this.successivo=null;
        this.precedente=null;
    }

    public Nodo()
    {
        this.info=null;
        this.successivo=null;
    }

    public Nodo getPrecedente() {
        return precedente;
    }

    public void setPrecedente(Nodo precedente) {
        this.precedente = precedente;
    }



    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo getSuccessivo() {
        return successivo;
    }

    public void setSuccessivo(Nodo successivo) {
        this.successivo = successivo;
    }



    public int compareTo(Nodo<T> nodo)
    {
        return this.info.compareTo(nodo.getInfo());
    }




}
