package org.hposadas.bibliotheque.services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {

    //firmas de métodos
    Optional<String> getUsername(HttpServletRequest req);
}
