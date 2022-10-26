<%@page contentType="text/html" pageEncoding="UTF-8" import="org.hposadas.biblioteca.models.*"%>
<%@ page import="org.hposadas.bibliotheque.services.LivreService" %>
<%@ page import="org.hposadas.bibliotheque.services.LivreServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hposadas.bibliotheque.services.LoginService" %>
<%@ page import="org.hposadas.bibliotheque.services.LoginServiceImpl" %>
<%@ page import="java.util.Optional" %>
<%@ page import="org.hposadas.bibliotheque.models.Livre" %>
<%
    List<Livre> livres = (List<Livre>) session.getAttribute("livres");
    LoginService auth = new LoginServiceImpl();
    Optional<String> usernameOptional = auth.getUsername(request);
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Bibliotheque STUDI</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="bg-black">
<h1 class="text-warning text-center">Liste des livres</h1>
<div class="text-center">
    <div class="btn-group">
        <button type="button" class="btn btn-primary p-1">Prêts en cours</button>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-primary p-1">Information du compte</button>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-primary p-1">Se déconnecter</button>
    </div>
</div>
<div class="row text-center m-1">
    <h1 class="text-warning">Aficher les livres</h1>
</div>

    <table class="table table-dark">
        <tr>
            <th scope="col">Titre</th>
            <th scope="col">Genre</th>
            <th scope="col">Author</th>
            <th scope="col">Langue</th>
            <th scope="col">Editeur</th>
            <th scope="col">Date publication</th>
            <%if (usernameOptional.isPresent()){%>
                <th scope="col">Demander en prêt</th>
            <%}%>
        </tr>


        <%--<%
            PrintWriter outp = response.getWriter();
                livres.forEach(livre -> {
                    outp.println("           <tr>");
                    outp.println("               <td>" + livre.getTitre() + "</td>");
                    outp.println("               <td>" + livre.getGenre() + "</td>");
                    outp.println("               <td>" + livre.getAuteur() + "</td>");
                    outp.println("               <td>" + livre.getLangue() + "</td>");
                    outp.println("               <td>" + livre.getEditeur() + "</td>");
                    outp.println("               <td>" + livre.getDatePublication() + "</td>");
                    if (usernameOptional.isPresent()){
                        outp.println("           <td><a href=\""
                                +request.getContextPath()
                                + "/rajouter-pret?id=" + livre.getId()
                                + "\">Demander en pret</a></td>");
                    }
                    outp.println("           </tr>");
        });%>--%>

        <%for (Livre libro: livres){%>
        <tr>
            <th scope="row"><%libro.getTitre();%></th>
            <td ><%libro.getGenre();%></td>
            <td ><%libro.getAuteur();%></td>
            <td ><%libro.getLangue();%></td>
            <td ><%libro.getEditeur();%></td>
            <td ><%libro.getDatePublication();%></td>
        </tr>
        <%}%>
    </table>

</body>
</html>