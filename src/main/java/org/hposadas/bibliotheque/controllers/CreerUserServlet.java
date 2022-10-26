package org.hposadas.bibliotheque.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hposadas.bibliotheque.models.Utilisateur;
import org.hposadas.bibliotheque.repositories.UserRepository;
import org.hposadas.bibliotheque.repositories.UtilisateurRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/create-user")
public class CreerUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");

        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Utilisateur user = new Utilisateur(1L, nom, prenom, email, password);

        UserRepository user1 = new UtilisateurRepositoryImpl(conn);
        try {
            user1.enregistrer(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("     <head>");
            out.println("         <meta charset=\"UTF-8\">");
            out.println("             <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
            out.println("         <title>Utilisateur crée</title>");
            out.println("     </head>");
            out.println("     <body>");
            out.println("         <h1>Utilisateur Crée avec succès</h1>");
            out.println("         <div>");
            out.println("         <a class=\"btn btn-success text-warning\" href=\"/bibliotheque/index.jsp\">Accueil</a>");
            out.println("         </div>");
            out.println("     </body>");
            out.println("</html>");
        }

    }
}
