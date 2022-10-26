package org.hposadas.bibliotheque.repositories;

import java.sql.SQLException;
import java.util.List;

public interface LivreRepository<T> {

    //signatures de méthodes
    List<T> lister() throws SQLException;
    List<T> parName(String name) throws SQLException;
}
