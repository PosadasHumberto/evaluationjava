<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%

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
    <div class="row justify-content-center">
        <div class="col-2 m-5">
            <a class="btn btn-primary">Parcourir la bibliothèque</a>
        </div>
        <div class="col-2 m-5">
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/connexion">Se connecter</a>
        </div>
        <div class="col-2 m-5">
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/index.jsp">Accueil</a>
        </div>
    </div>
    <div class="row text-center m-3">
        <h1 class="text-warning">Creation du compte</h1>
    </div>
    <form class="row justify-content-center" action="<%=request.getContextPath()%>/create-user" method="post">
        <div class="col-lg-4 col-xl-4 col-sm-11">
            <div class="form-group">
                <label for="nom" class="text-white">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" placeholder="Votre nom ici.">
                <small class="form-text text-muted text-warning">Ce champ est obligatoire *</small>
            </div>
            <div class="form-group">
                <label for="prenom" class="text-white">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Votre prénom ici.">
                <small class="form-text text-muted text-warning">Ce champ est obligatoire *</small>
            </div>
            <div class="form-group text-white">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="example@domain.com">
                <small class="form-text text-muted text-warning">Ce champ est obligatoire *</small>
            </div>
            <div class="form-group">
                <label for="password" class="text-white">Mot de passe</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="********">
                <small class="form-text text-muted text-warning">Ce champ est obligatoire *</small>
            </div>
            <%--<div class="form-group">
                <label for="passwordConf" class="text-white">Mot de passe</label>
                <input type="password" class="form-control" id="passwordConf" placeholder="********">
                <small class="form-text text-muted text-warning">Ce champ est obligatoire *</small>
            </div>--%>
            <button type="submit" class="btn btn-warning mt-3">Créer</button>
        </div>
    </form>
</body>
</html>