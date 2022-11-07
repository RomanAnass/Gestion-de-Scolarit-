<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login</title>
    <link rel="stylesheet" href="src/login/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="src/login/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="src/login/css/styles.css">
</head>

<body>
    <div class="login-clean">
        <form method="post" action="user/login">
            <h2 class="sr-only">Login </h2>
            <div class="illustration"><img src="src/login/img/logo%20mini.png"></div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email"></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: rgb(69,93,215);">Log In</button></div><a class="forgot" href="#">Forgot your email or password?</a></form>
    </div>
    <script src="src/login/js/jquery.min.js"></script>
    <script src="src/login/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>