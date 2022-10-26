<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <div class="row text-center m-5">
        <h1 class="text-warning">Evaluation Studi</h1>
    </div>
    <div class="row mt-5">
        <div class="col col-4 text-center">
            <div class="row m-2 justify-content-center">
                <div class="col-4">
                    <a class="btn btn-success text-warning" href="<%=request.getContextPath()%>/livres">Parcourir la bibliothèque</a>
                </div>
            </div>
            <div class="row m-2 justify-content-center">
                <div class="co-4">
                    <a class="btn btn-success text-warning" href="<%=request.getContextPath()%>/connexion">Se connecter</a>
                </div>
            </div>
            <div class="row m-2 justify-content-center">
                <div class="col-4">
                    <a class="btn btn-success text-warning" href="<%=request.getContextPath()%>/creationCompte.jsp">Créer un compte</a>
                </div>
            </div>
        </div>
        <div class="col col-6 m-2 ">
                <h2 class="text-warning">Bienvenue sur "Biblio", le site de la bibliothèque de Pontault-Combault.</h2>
        </div>
    </div>
</body>
</html>