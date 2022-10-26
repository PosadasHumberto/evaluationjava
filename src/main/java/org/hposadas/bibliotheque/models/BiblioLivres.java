package org.hposadas.bibliotheque.models;

public class BiblioLivres {

    //Attributes d'instance
    private Long id;
    private Long id_livre;
    private Long id_biblio;
    private int exemplaires;

    //constructors
    public BiblioLivres() {
    }

    public BiblioLivres(Long id, Long id_livre, Long id_biblio, int exemplaires) {
        this.id = id;
        this.id_livre = id_livre;
        this.id_biblio = id_biblio;
        this.exemplaires = exemplaires;
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_livre() {
        return id_livre;
    }

    public void setId_livre(Long id_livre) {
        this.id_livre = id_livre;
    }

    public Long getId_biblio() {
        return id_biblio;
    }

    public void setId_biblio(Long id_biblio) {
        this.id_biblio = id_biblio;
    }

    public int getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(int exemplaires) {
        this.exemplaires = exemplaires;
    }
}
