package org.hposadas.bibliotheque.services;

import org.hposadas.bibliotheque.models.Livre;
import org.hposadas.bibliotheque.repositories.LivreRepository;
import org.hposadas.bibliotheque.repositories.LivreRepositoryImpl;
import org.hposadas.bibliotheque.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LivreServiceImpl implements LivreService{

    //attributes d'instance
    private LivreRepository<Livre> repository;

    //constructor


    public LivreServiceImpl(Connection connection) {
        this.repository = new LivreRepositoryImpl(connection);
    }

    @Override
    public List<Livre> lister() {
        try{
            return repository.lister();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Livre> byName(String name) {
        try {
            return repository.parName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Livre> byId(Long id) {
        return lister().stream().filter(l->l.getId().equals(id)).findAny();
    }
}
