package org.hposadas.bibliotheque.models;

import java.time.LocalDate;

public class Livre {

    //attributes d'instance
    private Long id;
    private String titre;
    private String genre;
    private String auteur;
    private String langue;
    private String editeur;
    private String description;
    private String isbn;
    private LocalDate datePublication;

    //constructor
    public Livre() {

    }

    public Livre(Long id, String titre, String genre, String auteur, String langue, String editeur, String description, String isbn, LocalDate datePublication) {
        this.id = id;
        this.titre = titre;
        this.genre = genre;
        this.auteur = auteur;
        this.langue = langue;
        this.editeur = editeur;
        this.description = description;
        this.isbn = isbn;
        this.datePublication = datePublication;
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }


}
