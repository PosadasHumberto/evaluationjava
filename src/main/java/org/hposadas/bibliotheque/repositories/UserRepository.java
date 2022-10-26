package org.hposadas.bibliotheque.repositories;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository<T> {

    //signatures de méthodes
    void enregistrer(T t) throws SQLException;
}
