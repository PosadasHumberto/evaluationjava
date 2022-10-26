package org.hposadas.bibliotheque.repositories;

import org.hposadas.bibliotheque.models.Livre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreRepositoryImpl implements LivreRepository<Livre>{

    //attributes d'instance
    private Connection conn;

    //constructor
    public LivreRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    //implementation des méthdes
    @Override
    public List<Livre> lister(){

        List<Livre> livres = new ArrayList<>();

        try(Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM livres")){
            while (res.next()){
                Livre l = getLivre(res);
                livres.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livres;
    }

    @Override
    public List<Livre> parName(String name) throws SQLException {
        List<Livre> livres = new ArrayList<>();

        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM livres as l WHERE l.titre LIKE ?")){
           stmt.setString(1, "%" + name + "%");

           try(ResultSet res = stmt.executeQuery()){
               while (res.next()){
                   Livre l = getLivre(res);
                   livres.add(l);
               }
           }
        }
        return livres;
    }


    private static Livre getLivre(ResultSet res) throws SQLException {
        Livre l = new Livre();
        l.setId(res.getLong("id"));
        l.setTitre(res.getString("titre"));
        l.setGenre(res.getString("genre"));
        l.setAuteur(res.getString("auteur"));
        l.setLangue(res.getString("langue"));
        l.setEditeur(res.getString("editeur"));
        l.setDescription(res.getString("description"));
        l.setIsbn(res.getString("isbn"));
        l.setDatePublication(res.getDate("date_publication").toLocalDate());
        return l;
    }
}
