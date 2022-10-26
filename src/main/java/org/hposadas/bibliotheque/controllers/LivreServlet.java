package org.hposadas.bibliotheque.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hposadas.bibliotheque.models.Livre;
import org.hposadas.bibliotheque.repositories.LivreRepository;
import org.hposadas.bibliotheque.repositories.LivreRepositoryImpl;
import org.hposadas.bibliotheque.repositories.Repository;
import org.hposadas.bibliotheque.services.LivreService;
import org.hposadas.bibliotheque.services.LivreServiceImpl;
import org.hposadas.bibliotheque.services.LoginService;
import org.hposadas.bibliotheque.services.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/livres.html", "/livres"})
public class LivreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /*LivreService service = new LivreServiceImpl();
        List<Livre> livres = service.lister();*/

        /*HttpSession session = req.getSession();
        session.setAttribute("livres", livres);*/

        //getServletContext().getRequestDispatcher("/livres.jsp").forward(req, resp);

        Connection conn = (Connection) req.getAttribute("conn");
        LivreService service = new LivreServiceImpl(conn);
        List<Livre> livres = service.lister();

        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("     <head>");
            out.println("         <meta charset=\"UTF-8\">");
            out.println("             <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
            out.println("         <title class=\"text-white\">Liste des livres</title>");
            out.println("     </head>");
            out.println("     <body class=\"bg-black\">");
            out.println("         <h1 class=\"text-white text-center\">Liste des livres</h1>");
            out.println("         <table class=\"table table-dark\">");
            out.println("           <tr>");
            out.println("               <th scope=\"col\">Titre</th>");
            out.println("               <th scope=\"col\">Genre</th>");
            out.println("               <th scope=\"col\">Author</th>");
            out.println("               <th scope=\"col\">Langue</th>");
            out.println("               <th scope=\"col\">Editeur</th>");
            out.println("               <th scope=\"col\">Date de publication</th>");
            if (usernameOptional.isPresent()){
                out.println("               <th scope=\"col\">Demander en prêt</th>");
            }
            out.println("           </tr>");
            livres.forEach(l -> {
                out.println("           <tr>");
                out.println("               <td scope=\"row\">" + l.getTitre() + "</td>");
                out.println("               <td>" + l.getGenre() + "</td>");
                out.println("               <td>" + l.getAuteur() + "</td>");
                out.println("               <td>" + l.getLangue() + "</td>");
                out.println("               <td>" + l.getEditeur() + "</td>");
                out.println("               <td>" + l.getDatePublication() + "</td>");
                if (usernameOptional.isPresent()){
                    out.println("           <td><a href=\""
                            +req.getContextPath()
                            + "/rajouter-pret?id=" + l.getId()
                            + "\">Demander en pret</a></td>");
                }
                out.println("           </tr>");
            });
            out.println("         </table>");
            out.println("         <div>");
            out.println("         <a class=\"btn btn-success text-warning\" href=\"/bibliotheque/index.jsp\">Accueil</a>");
            out.println("         </div>");
            out.println("         <div>");
            out.println("         <h2 class=\"text-center text-white\">Recherche par titre</h2>");
            out.println("         <form class=\"text-center\" action=\"" + req.getContextPath() + "/livres\" method=\"post\">");
            out.println("           <input type=\"text\" name=\"titre\">");
            out.println("           <input type=\"submit\" value=\"Rechercher\">");
            out.println("         </form>");
            out.println("         </div>");
            out.println("     </body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = (Connection) req.getAttribute("conn");
        LivreRepository service = new LivreRepositoryImpl(conn);
        List<Livre> livres = null;
        try {
            livres = service.parName(req.getParameter("titre"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        if (!livres.isEmpty()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("         <meta charset=\"UTF-8\">");
                out.println("             <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
                out.println("         <title class=\"text-white\">Liste des livres</title>");
                out.println("     </head>");
                out.println("     <body class=\"bg-black\">");
                out.println("         <h1 class=\"text-white text-center\">Liste des livres</h1>");
                out.println("         <table class=\"table table-dark\">");
                out.println("           <tr>");
                out.println("               <th scope=\"col\">Titre</th>");
                out.println("               <th scope=\"col\">Genre</th>");
                out.println("               <th scope=\"col\">Author</th>");
                out.println("               <th scope=\"col\">Langue</th>");
                out.println("               <th scope=\"col\">Editeur</th>");
                out.println("               <th scope=\"col\">Date de publication</th>");
                if (usernameOptional.isPresent()) {
                    out.println("               <th scope=\"col\">Demander en prêt</th>");
                }
                out.println("           </tr>");
                livres.forEach(l -> {
                    out.println("           <tr>");
                    out.println("               <td scope=\"row\">" + l.getTitre() + "</td>");
                    out.println("               <td>" + l.getGenre() + "</td>");
                    out.println("               <td>" + l.getAuteur() + "</td>");
                    out.println("               <td>" + l.getLangue() + "</td>");
                    out.println("               <td>" + l.getEditeur() + "</td>");
                    out.println("               <td>" + l.getDatePublication() + "</td>");
                    if (usernameOptional.isPresent()) {
                        out.println("           <td><a href=\""
                                + req.getContextPath()
                                + "/rajouter-pret?id=" + l.getId()
                                + "\">Demander en pret</a></td>");
                    }
                    out.println("           </tr>");
                });
                out.println("         </table>");
                out.println("         <div>");
                out.println("         <a class=\"btn btn-success text-warning\" href=\"/bibliotheque/index.jsp\">Accueil</a>");
                out.println("         </div>");
                out.println("     </body>");
                out.println("</html>");
            }
        } else {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("         <meta charset=\"UTF-8\">");
                out.println("             <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
                out.println("         <title class=\"text-white\">Liste des livres</title>");
                out.println("     </head>");
                out.println("     <body class=\"bg-black\">");
                out.println("         <h1 class=\"text-white text-center\">Aucune correspondance</h1>");
                out.println("     </body>");
                out.println("</html>");
            }
        }
    }
}
