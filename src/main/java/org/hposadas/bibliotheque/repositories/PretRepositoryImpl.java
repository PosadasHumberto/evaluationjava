package org.hposadas.bibliotheque.repositories;

import org.hposadas.bibliotheque.models.Biblioteque;
import org.hposadas.bibliotheque.models.Pret;
import org.hposadas.bibliotheque.models.ItemPret;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PretRepositoryImpl implements Repository<Pret>{

    //attributes d'instance
    private Connection conn;

    //constructor
    public PretRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    //implementation des méthodes
    @Override
    public List<Pret> lister() throws SQLException {

        List<Pret> prets = new ArrayList<>();
        try(Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM prets")){
            while(result.next()){
                Biblioteque b = new Biblioteque();
                ItemPret i = new ItemPret();
                i.setId(result.getLong("id"));


            }
        }
        return prets;
    }

    @Override
    public List<Pret> parName(String name) {
        return null;
    }

    @Override
    public void enregistrer(Pret pret) {

    }

    @Override
    public void supprimer(Long id) {

    }
}
