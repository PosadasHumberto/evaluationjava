package org.hposadas.bibliotheque.repositories;

import org.hposadas.bibliotheque.models.Utilisateur;

import java.sql.*;
import java.util.List;

public class UtilisateurRepositoryImpl implements UserRepository<Utilisateur>{

    //attributes d'instance
    private Connection conn;

    //constructor
    public UtilisateurRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    //implementation des méthodes
    @Override
    public void enregistrer(Utilisateur utilisateur) throws SQLException {

        try(PreparedStatement stmt = conn.prepareStatement("INSERT INTO utilisateurs(nom, prenom, email, password) VALUES (?,?,?,?)")){
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getPassword());
            stmt.executeUpdate();
        }
    }
}
