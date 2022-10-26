package org.hposadas.bibliotheque.repositories;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    //signatures de méthodes
    List<T> lister() throws SQLException;
    List<T> parName(String name) throws SQLException;
    void enregistrer(T t) throws SQLException;
    void supprimer(Long id) throws SQLException;

}
