<%@page contentType="text/html" pageEncoding="UTF-8" import="org.hposadas.bibliotheque.models.*" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@ page import="org.hposadas.bibliotheque.models.ItemPret" %>
<%@ page import="org.hposadas.bibliotheque.models.Pret" %>
<%
//obtenir les prets depuis la session
   Pret pret = (Pret) session.getAttribute("pret");
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Bibliotheque STUDI</title>
    <!--<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet"/> -->
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="bg-black">
    <div class="row text-center m-5">
        <h1 class="text-warning">Prêts en cours</h1>
    </div>
    <div class="text-center">
        <div class="btn-group">
            <a type="button" class="btn btn-success text-warning p-1">Parcourir la bibliothèque</a>
        </div>
        <div class="btn-group">
            <a type="button" class="btn btn-success text-warning p-1" href="<%=request.getContextPath()%>/infoUser">Information du compte</a>
        </div>
        <div class="btn-group">
            <a type="button" class="btn btn-success text-warning p-1" href="<%=request.getContextPath()%>/logout">Se déconnecter</a>
        </div>
    </div>
    <h1 class="text-center text-warning my-3">Afficher prêts</h1>
<% if (pret == null || pret.getPrets().isEmpty()){%>
    <p class="text-warning text-center">Désolé, il n'y a pas des prêts en cours a afficher actuellement.</p>
<% } else {%>
    <div class="mx-3">
        <table class="table table-dark">
            <tr>
                <th scope="col">Id</th>
                <%--<th scope="col">Bibliotheque</th>--%>
                <th scope="col">Utilisateur</th>
                <th scope="col">Livre</th>
                <th scope="col">Date debout</th>
                <th scope="col">Date fin</th>
                <th scope="col">Prolongements</th>
            </tr>
            <% for (ItemPret item: pret.getPrets()){%>
            <tr>
                <th scope="row"><%=item.getId()%></th>
                <%--<td ><%=item.getBiblioteque().getNom()%></td>--%>
                <td ><%=item.getUtilisateur().getNom() + " " + item.getUtilisateur().getPrenom()%></td>
                <td ><%=item.getLivre().getTitre()%></td>
                <td ><%=item.getDateDebut().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))%></td>
                <td ><%=item.getDateFin().format(DateTimeFormatter.ofPattern("d-MM-yyyy"))%></td>
                <td ><%=item.getProlongements()%></td>
            </tr>
            <% } %>
        </table>
    </div>
<% } %>
<p class="text-center"><a href="<%request.getContextPath();%>/bibliotheque/livres">Demander d'autres prêts</a></p>
<p class="text-center"><a href="<%request.getContextPath();%>/bibliotheque/index.jsp">Home</a></p>
</body>
</html>