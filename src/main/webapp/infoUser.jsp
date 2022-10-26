<%@ page import="org.hposadas.bibliotheque.models.Utilisateur" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% Utilisateur user = (Utilisateur) request.getAttribute("user");%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Bibliotheque STUDI</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="bg-black">
    <div class="row justify-content-center">
        <div class="col-2 m-5">
            <a class="btn btn-primary">">Parcourir la bibliothèque</a>
        </div>
        <div class="col-2 m-5">
            <a class="btn btn-primary">Prêts en cours</a>
        </div>
        <div class="col-2 m-5">
            <a class="btn btn-primary">Se Deconnecter</a>
        </div>
        <div class="col-2 m-5">
            <a class="btn btn-primary">Accueil</a>
        </div>
    </div>
    <div class="row text-center m-5">
        <h1 class="text-warning">Information du compte</h1>
    </div>

    <div class="row justify-content-center">
        <div class="col col-1">
            <h3 class="text-white">Nom:</h3>
        </div>
        <div class="col col-4">
            <input name="screenNom" id="screenNom" cols="25" rows="1" readonly>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col col-1">
            <h3 class="text-white">Prénom:</h3>
        </div>
        <div class="col col-4">
            <input name="screenPrenom" id="screenPrenom" cols="25" rows="1">
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col col-1">
            <h3 class="text-white">Email:</h3>
        </div>
        <div class="col col-4">
            <input name="screenMail" id="screenMail" cols="25" rows="1">
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col col-1">
            <h3 class="text-white">Password:</h3>
        </div>
        <div class="col col-4">
            <input name="screenPassword" id="screenPassword" cols="25" rows="1">
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-3">
            <input type="submit" class="btn btn-warning">Modifier le compte</input>
        </div>
    </div>

</body>
</html>