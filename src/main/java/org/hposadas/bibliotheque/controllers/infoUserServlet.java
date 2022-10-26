package org.hposadas.bibliotheque.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hposadas.bibliotheque.models.Utilisateur;
import org.hposadas.bibliotheque.services.LoginService;
import org.hposadas.bibliotheque.services.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/infoUser")
public class infoUserServlet extends HttpServlet {

    private Connection conn;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        conn = (Connection) req.getAttribute("conn");
        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional = auth.getUsername(req);
        if (usernameOptional.isPresent()) {
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM utilisateurs WHERE email=?")) {
                stmt.setString(1, usernameOptional.get());
                try (ResultSet res = stmt.executeQuery()) {
                    if (res.next()) {
                        Utilisateur user = new Utilisateur();
                        user.setId(res.getLong("id"));
                        user.setNom(res.getString("nom"));
                        user.setPrenom(res.getString("prenom"));
                        user.setEmail(res.getString("email"));
                        user.setPassword(res.getString("password"));
                        //HttpSession session = req.getSession();
                        //session.setAttribute("user", user);
                        //resp.sendRedirect(req.getContextPath() + "/infoUser.jsp");

                        resp.setContentType("text/html;charset=UTF-8");
                        try (PrintWriter out = resp.getWriter()) {

                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("     <head>");
                            out.println("         <meta charset=\"UTF-8\">");
                            out.println("             <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">");
                            out.println("         <title>Info Utilisateur</title>");
                            out.println("     </head>");
                            out.println("     <body class=\"bg-black\">");
                            out.println("           <div class=\"row justify-content-center\">");
                            out.println("               <div class=\"col-2 m-5\">");
                            out.println("                               <a class=\"btn btn-primary\" href=\"" + req.getContextPath() + "/livres\">Parcourir la bibliothèque</a>");
                            out.println("               </div>");

                            out.println("               <div class=\"col-2 m-5\">");
                            out.println("                               <a class=\"btn btn-primary\" href=\"" + req.getContextPath() + "/afficher-prets\">Prets en cours</a>");
                            out.println("               </div>");

                            out.println("               <div class=\"col-2 m-5\">");
                            out.println("                               <a class=\"btn btn-primary\" href=\"" + req.getContextPath() + "/\">Accueil</a>");
                            out.println("               </div>");
                            out.println("           </div>");

                            out.println("           <div class=\"row text-center m-5\">");
                            out.println("               <h1 class=\"text-warning\">Information du compte</h1>");
                            out.println("           </div>");

                            out.println("        <form action=\""+ req.getContextPath() + "/infoUser\" method=\"post\">");

                            out.println("           <div class=\"row justify-content-center form-group\">");
                            out.println("               <div class=\"col col-2\">");
                            out.println("                   <h3 class=\"text-white\">ID:</h3>");
                            out.println("               </div>");
                            out.println("               <div class=\"col col-4\">");
                            out.println("                   <input class=\"form-control\" name=\"screenid\" id=\"screenid\" cols=\"25\" rows=\"1\" value=\""+ user.getId() +"\" readonly >");
                            out.println("               </div>");
                            out.println("          </div>");

                            out.println("           <div class=\"row justify-content-center form-group\">");
                            out.println("               <div class=\"col col-2\">");
                            out.println("                   <h3 class=\"text-white\">Nom:</h3>");
                            out.println("               </div>");
                            out.println("               <div class=\"col col-4\">");
                            out.println("                   <input class=\"form-control\" name=\"screennom\" id=\"screennom\" cols=\"25\" rows=\"1\" value=\""+ user.getNom() +"\">");
                            out.println("               </div>");
                            out.println("          </div>");

                            out.println("           <div class=\"row justify-content-center form-group\">");
                            out.println("               <div class=\"col col-2\">");
                            out.println("                   <h3 class=\"text-white\">Prenom:</h3>");
                            out.println("               </div>");
                            out.println("               <div class=\"col col-4\">");
                            out.println("                   <input class=\"form-control\" name=\"screenprenom\" id=\"screenprenom\" cols=\"25\" rows=\"1\" value=\""+ user.getPrenom() +"\">");
                            out.println("               </div>");
                            out.println("          </div>");

                            out.println("           <div class=\"row justify-content-center form-group\">");
                            out.println("               <div class=\"col col-2\">");
                            out.println("                   <h3 class=\"text-white\">Email:</h3>");
                            out.println("               </div>");
                            out.println("               <div class=\"col col-4\">");
                            out.println("                   <input class=\"form-control\" name=\"screenemail\" id=\"screenemail\" cols=\"25\" rows=\"1\" value=\""+ user.getEmail() +"\">");
                            out.println("               </div>");
                            out.println("          </div>");

                            out.println("           <div class=\"row justify-content-center form-group\">");
                            out.println("               <div class=\"col col-2\">");
                            out.println("                   <h3 class=\"text-white\">Password:</h3>");
                            out.println("               </div>");
                            out.println("               <div class=\"col col-4\">");
                            out.println("                   <input class=\"form-control\" name=\"screenpassword\" id=\"screenpassword\" cols=\"25\" rows=\"1\" value=\""+ user.getPassword() +"\">");
                            out.println("               </div>");
                            out.println("          </div>");

                            out.println("           <div class=\"row justify-content-center form-group\">");
                            out.println("               <div class=\"col-3\">");
                            out.println("                   <input class=\"btn btn-primary\" type=\"submit\" value=\"Modifier\">");
                            out.println("               </div>");
                            out.println("          </div>");

                            out.println("        </form>");

                            out.println("     </body>");
                            out.println("</html>");
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        conn = (Connection) req.getAttribute("conn");
        LoginService auth = new LoginServiceImpl();
        Long id = Long.valueOf(req.getParameter("screenid"));
        String nom = req.getParameter("screennom");
        String prenom = req.getParameter("screenprenom");
        String email = req.getParameter("screenemail");
        String password = req.getParameter("screenpassword");


        try(PreparedStatement stmt = conn.prepareStatement("UPDATE utilisateurs SET nom=?, prenom=?,email=?,password=? WHERE id=?")){
            stmt.setString(1,nom);
            stmt.setString(2,prenom);
            stmt.setString(3,email);
            stmt.setString(4, password);
            stmt.setLong(5, id);
            stmt.executeUpdate();

            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("     <head>");
                out.println("         <meta charset=\"UTF-8\">");
                out.println("         <title>Données</title>");
                out.println("     </head>");
                out.println("     <body>");
                out.println("         <h2>" + nom + "</h2>");
                out.println("         <h2>" + prenom + "</h2>");
                out.println("         <h2>" + email + "</h2>");
                out.println("         <h2>" + password + "</h2>");
                out.println("     </body>");
                out.println("</html>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
