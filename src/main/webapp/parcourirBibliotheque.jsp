<%@page contentType="text/html" pageEncoding="UTF-8" import="org.hposadas.biblioteca.models.*"%>
<%@ page import="org.hposadas.bibliotheque.services.LivreService" %>
<%@ page import="org.hposadas.bibliotheque.services.LivreServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hposadas.bibliotheque.services.LoginService" %>
<%@ page import="org.hposadas.bibliotheque.services.LoginServiceImpl" %>
<%@ page import="java.util.Optional" %>
<%@ page import="org.hposadas.bibliotheque.models.Livre" %>
<%
    LivreService service = new LivreServiceImpl();
    List<Livre> livres = service.lister();

    LoginService auth = new LoginServiceImpl();
    Optional<String> usernameOptional = auth.getUsername(request);
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
        <h1 class="text-warning">Rechercher dans la Bibliothèque</h1>
    </div>
    <div class="row m-5">
        <div class="container">
            <div class="row bg-info">
                <form action="">
                    <div class="col form-group">
                        <label for="titre">Titre:</label>
                        <input type="text" class="form-control" id="titre">
                    </div>
                    <div class="col form-group">
                        <label for="auteur">Auteur:</label>
                        <input type="text" class="form-control" id="auteur">
                    </div>
                    <div class="col form-group">
                        <label for="genre">Genre:</label>
                        <input type="text" class="form-control" id="genre">
                    </div>
                    <div class="col form-group">
                        <label for="langue">Langue:</label>
                        <input type="text" class="form-control" id="langue">
                    </div>
                    <div class="col">
                        <button class="btn btn-secondary mt-3" type="submit">Recherche</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container bg-secondary">
        <div class="row">
            <div class="col col-6">
                <div class="row m-2">
                    <label for="titreScreen">Titre:</label>
                    <textarea name="titreScreen" id="titreScreen" cols="25" rows="1"></textarea>
                </div>
                <div class="row m-2">
                    <label for="genreScreen">Genre:</label>
                    <textarea name="genreScreen" id="genreScreen" cols="25" rows="1"></textarea>
                </div>
                <div class="row m-2">
                    <label for="publicationDate">Date de publication:</label>
                    <textarea name="publicationDate" id="publicationDate" cols="25" rows="1"></textarea>
                </div>
            </div>
            <div class="col col-6">
                <div class="row m-2">
                    <label for="auteurScreen">Auteur:</label>
                    <textarea name="auteurScreen" id="auteurScreen" cols="30" rows="1"></textarea>
                </div>
                <div class="row m-2">
                    <label for="isbnScreen">ISBN:</label>
                    <textarea name="isbnScreen" id="isbnScreen" cols="30" rows="1"></textarea>
                </div>
                <div class="row m-2">
                    <label for="editeurScreen">Editeur:</label>
                    <textarea name="editeurScreen" id="editeurScreen" cols="30" rows="1"></textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <label for="presentationScreen">Presentation:</label>
            <textarea class="m-1" name="presentationScreen" id="presentationScreen" cols="20" rows="6"></textarea>
        </div>
        <div class="row">
            <label for="disponibiliteScreen">Disponibilité:</label>
            <textarea class="m-1" name="disponibiliteScreen" id="disponibiliteScreen" cols="20" rows="3"></textarea>
        </div>
    </div>
</body>
</html>