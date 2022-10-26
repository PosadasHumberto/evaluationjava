package org.hposadas.bibliotheque.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.hposadas.bibliotheque.services.LoginService;
import org.hposadas.bibliotheque.services.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet({"/connexion.html", "/connexion"})
public class ConnexionServlet extends HttpServlet {

    private Connection conn;
    /*
    final static String EMAIL = "admin@test.com";
    final static String PASSWORD = "12345";
    */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        if (usernameOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("         <meta charset=\"UTF-8\">");
                out.println("         <title>Bonjour " + usernameOptional.get()+ "</title>");
                out.println("     </head>");
                out.println("     <body>");
                out.println("         <h1>Bonjour " + usernameOptional.get()+ ", vous avez deja une session ouverte.</h1>");
                out.println("         <p><a href='" + req.getContextPath() + "/index.jsp'>Retour a l'accueil</a></p>");
                out.println("         <p><a href='" + req.getContextPath() + "/logout'>Se Deconnecter</a></p>");
                out.println("     </body>");
                out.println("</html>");
            }
        }
        getServletContext().getRequestDispatcher("/connexion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        conn = (Connection) req.getAttribute("conn");

        try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utilisateurs WHERE email=? AND password=?")) {
            stmt.setString(1,email);
            stmt.setString(2,password);
            try(ResultSet res = stmt.executeQuery()){
                if(res.next()){
                    HttpSession session = req.getSession();
                    session.setAttribute("username", email);

                    resp.sendRedirect(req.getContextPath() + "/index.jsp");
                }else{
                    resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Desolé, vous n'etes pas autorisé pour acceder a cette page.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        /*
        if (EMAIL.equals(email) && PASSWORD.equals(password)) {

            HttpSession session = req.getSession();
            session.setAttribute("username", email);

            resp.sendRedirect(req.getContextPath() + "/index.jsp");

        }else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Desolé, vous n'etes pas autorisé pour acceder a cette page.");
        }
        */
    }
}
