package org.hposadas.bibliotheque.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class ItemPret {

    //attributes d'instance
    private Long id;
    private BiblioLivres biblioLivres;
    private Utilisateur utilisateur;
    private Livre livre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int prolongements;
    private String etat;


    //constructor
    public ItemPret() {
    }

    public ItemPret(Long id, BiblioLivres biblioLivres, Utilisateur utilisateur, Livre livre, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.biblioLivres = biblioLivres;
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prolongements = 0;
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BiblioLivres getBiblioLivres() {
        return biblioLivres;
    }

    public void setBiblioLivres(BiblioLivres biblioLivres) {
        this.biblioLivres = biblioLivres;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getProlongements() {
        return prolongements;
    }

    public void setProlongements(int prolongements) {
        this.prolongements = prolongements;
    }
//methodes

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPret itemPret = (ItemPret) o;
        return Objects.equals(id, itemPret.id);
    }
}
