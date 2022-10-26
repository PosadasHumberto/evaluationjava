package org.hposadas.bibliotheque.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.hposadas.bibliotheque.utilities.ConnectionDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class CoonnectionDBFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /**
         * Filtre qui servira pour se connecter a la base de données, a noter que la
         * methode doFilter de l'interface Filter, permet d'effetctuer certaines actions
         * avant et aprés avoir execute le servlet.
         */
        try (Connection conn = ConnectionDB.getConnection()){

            /**
             * Il faut s'assurer que l'autoCommit se trouve en false, de cette maniere
             * si jamais une instruction sql faille, aucune instruction sql meme les instructions
             * qui ont eu success s'effectuent.
             * Pour lancer une transaction, il faut mettre le mode autoCommit a false grace au méthode setAutoCommit()
             * utiliser cette maniere de travailler nous permet d'avoir le control de ce qui se passe et quand il se passe.
             */

            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try {
                servletRequest.setAttribute("conn", conn);  //passer la connection au request pour qu'elle puisse etre capté par le servlet. La connection sera disponible pendant toute la durée de vie du request
                filterChain.doFilter(servletRequest, servletResponse);  //doFilter() est le resultat d'une demande, cette methode nous retourne l'appel a la methode doPost() ou bien doGet() selon le servlet
                conn.commit();
            } catch (ServletException | SQLException e) {
                conn.rollback();
                ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
