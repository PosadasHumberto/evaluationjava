package org.hposadas.bibliotheque.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hposadas.bibliotheque.models.*;
import org.hposadas.bibliotheque.services.LivreService;
import org.hposadas.bibliotheque.services.LivreServiceImpl;
import org.hposadas.bibliotheque.services.LoginService;
import org.hposadas.bibliotheque.services.LoginServiceImpl;

import java.io.IOException;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@WebServlet("/rajouter-pret")
public class RajouterLivreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        BiblioLivres bl = new BiblioLivres();
        Utilisateur user = new Utilisateur();


        Connection conn = (Connection) req.getAttribute("conn");
        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional = auth.getUsername(req);
        if (usernameOptional.isPresent()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM biblio_livres WHERE id=?")) {
                stmt.setLong(1, 1L);                 //je travail au debut seulement avec une seule bibliotheque
                try (ResultSet res = stmt.executeQuery()) {
                    if (res.next()) {
                        bl.setId(1L);
                        bl.setId_biblio(res.getLong("id_biblio"));
                        bl.set
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }*/

            LoginService auth = new LoginServiceImpl();
            Optional<String> usernameOptional = auth.getUsername(req);
            Connection conn = (Connection) req.getAttribute("conn");
            Biblioteque bilbliotheque1 = new Biblioteque(1L, "Biblioteque 1");
            Utilisateur user1 = new Utilisateur();

            String email = usernameOptional.get();
            try(PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utilisateurs WHERE email=?")){
                stmt.setString(1, email);
                try(ResultSet res = stmt.executeQuery()){
                    if (res.next()){
                        user1.setId(res.getLong("id"));
                        user1.setNom(res.getString("nom"));
                        user1.setPrenom(res.getString("prenom"));
                        user1.setEmail(res.getString("email"));
                        user1.setPassword(res.getString("password"));
                    }
                    //stmt.executeUpdate();
                }

            //Utilisateur user1 = new Utilisateur(1L, b, "Posadas", "Humberto", "user1@test.com", "12345");
            Long livreId = Long.parseLong(req.getParameter("id"));
            LivreService service = new LivreServiceImpl(conn);
            Optional<Livre> livre = service.byId(livreId);
            if (livre.isPresent()) {
                BiblioLivres bl = new BiblioLivres(1L, livre.get().getId(), bilbliotheque1.getId(), 10);
                LocalDate date = LocalDate.now();
                LocalDate datefin = date.plusDays(15);

                ItemPret itemPret = new ItemPret(1L, bl, user1, livre.get(), date, date.plusDays(15));
                try(PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO prets(id_bibliolivres, id_user, date_depart, date_fin, prolongements, etat) VALUES (?,?,?,?,?,?)")){
                    stmt2.setLong(1,bl.getId());
                    stmt2.setLong(2,user1.getId());
                    stmt2.setDate(3, Date.valueOf(date));
                    stmt2.setDate(4, Date.valueOf(datefin));
                    stmt2.setInt(5, 0);
                    stmt2.setString(6, "En cours");
                    stmt2.executeUpdate();
                }
                Pret pret;
                HttpSession session = req.getSession();
                if (session.getAttribute("pret") == null) {
                    pret = new Pret();
                    session.setAttribute("pret", pret);
                } else {
                    pret = (Pret) session.getAttribute("pret");
                }
                pret.addItemPret(itemPret);
            }
            resp.sendRedirect(req.getContextPath() + "/afficher-prets");

        } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
