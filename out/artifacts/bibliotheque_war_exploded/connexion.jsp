<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%

%>

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
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/livres">Parcourir la bibliothèque</a>
        </div>
        <div class="col-2 m-5">
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/creationCompte.jsp">Créer un compte</a>
        </div>
        <div class="col-2 m-5">
            <a class="btn btn-primary" href="<%=request.getContextPath()%>/index.jsp">Accueil</a>
        </div>
    </div>
    <div class="row text-center m-5">
        <h1 class="text-warning">Connexion</h1>
    </div>
    <div class="row justify-content-center">
        <div class="col col-4">
            <form action="/bibliotheque/connexion" method="post">
                <div class="form-group">
                    <label for="email" class="text-warning">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="example@domain.com">
                </div>
                <div class="form-group">
                    <label for="password" class="text-warning">Mot de passe:</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="******">
                </div>
                <div class="row justify-content-center">
                    <div class="col col-4">
                        <input type="submit" value="Se connecter">
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>