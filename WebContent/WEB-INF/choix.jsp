<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Gestion de choix</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/css/card-3-column-animation-shadows-images.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/source/assets/css/styles.css">
</head>

<body bgcolor="#F0FFF0">
<p> Bonjour : ${user.login} </p>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-auto col-sm-12 col-md-12 col-lg-4 col-xl-4 offset-lg-2" style="padding-top: 15px;padding-bottom: 15px;padding-right: 15px;padding-left: 15px;">
                    <div class="bg-light border rounded shadow card" data-bs-hover-animate="pulse"><img class="card-img-top" src="${pageContext.request.contextPath}/source/assets/img/precarite-etudiants-inegalites-pauvrete.jpg" style="height: 217px;">
                        <div class="card-body">
                            <h3 class="card-title" style="font-family: Antic, sans-serif;color: rgb(81,87,94);">Gestion Etudiant</h3>
                            <p class="card-text" style="font-family: Antic, sans-serif;color: rgb(81,87,94);"></p><a href="http://localhost:8080/Gestion_ecole/home/etudiant"><button class="btn btn-outline-success" type="button" style="font-weight: normal;font-family: Antic, sans-serif;">Gérer</button></a></div>
                    </div>
                </div>
                <div class="col-auto col-sm-12 col-md-12 col-lg-4 col-xl-4 offset-lg-1" style="padding-top: 15px;padding-bottom: 15px;padding-right: 15px;padding-left: 15px;margin-right: 0px;margin-bottom: 0px;">
                    <div class="bg-light border rounded shadow card" data-bs-hover-animate="pulse"><img class="card-img-top" src="${pageContext.request.contextPath}/source/assets/img/pancarte.jpg" style="height: 217px;">
                        <div class="card-body">
                            <h3 class="card-title" style="font-family: Antic, sans-serif;color: rgb(81,87,94);">Gestion Filiére</h3>
                            <p class="card-text" style="font-family: Antic, sans-serif;color: rgb(81,87,94);"></p><a href="http://localhost:8080/Gestion_ecole/home/filiere"><button class="btn btn-outline-success" type="submit" style="font-weight: normal;font-family: Antic, sans-serif;"> Gérer </button></a></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="${pageContext.request.contextPath}/source/assets/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/source/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/source/assets/js/bs-init.js"></script>
</body>

</html>