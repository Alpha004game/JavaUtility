package personale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francesco
 */
public class Persona implements Comparable<Persona>{

    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta=eta;
    }
    public Persona(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int compareTo(Persona persona)
    {
        if(this.eta==persona.getEta())
            return 0;
        else if(this.eta<persona.getEta())
            return -1;
        return 1;
    }

    @Override
    public String toString() {
        return "Persona{" + "nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + '}';
    }

    public String toStringWrite()
    {
        return "Persona"+"-"+nome+"-"+cognome+"-"+eta;
    }
    public boolean equals(Persona p)
    {
        return nome.equals(p.getNome()) && cognome.equals(p.getCognome()) && eta==p.getEta();
    }




}

