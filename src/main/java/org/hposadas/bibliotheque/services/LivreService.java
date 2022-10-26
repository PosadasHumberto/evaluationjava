package org.hposadas.bibliotheque.services;

import org.hposadas.bibliotheque.models.Livre;

import java.util.List;
import java.util.Optional;

public interface LivreService {

    //signature des méthodes
    List<Livre> lister();
    List<Livre> byName(String name);

    Optional<Livre> byId(Long id);
}
