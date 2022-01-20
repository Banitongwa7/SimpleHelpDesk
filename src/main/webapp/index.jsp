<%--
  Created by IntelliJ IDEA.
  User: davidb
  Date: 08/01/2022
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="database.Dao" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS here -->
    <link rel="stylesheet" href="css/loginStyle.css"/>
    <!-- Javascript here -->
    <script defer src="js/login.js"></script>

    <title>HelpDesk | Login</title>
</head>
<body>

<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="<%=request.getContextPath()%>/signup" method="post">
            <h1>Créer votre compte</h1>
            <input type="text" name="nomNew" placeholder="Nom"/>
            <input type="text" name="prenomNew" placeholder="Prénom"/>
            <input type="email" name="emailNew" placeholder="Email"/>
            <input type="password" name="passwordNew" placeholder="Mot de passe" />
            <input type="password" name="confirmNew" placeholder="Confirmer mot de passe" />
            <button>Valider</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="<%=request.getContextPath()%>/login" method="post">
            <h1>HelpDesk</h1>
            <span>Se connecter avec son compte</span>
            <input type="email" name="email" placeholder="Email" />
            <input type="password" name="password" placeholder="Password" />
            <a href="#">Mot de passe oublié ?</a>
            <button>Se connecter</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Content de te revoir ! </h1>
                <p>Pour rester en contact avec nous, veuillez vous connecter avec vos informations personnelles</p>
                <button class="ghost" id="signIn">Se connecter</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Salut !</h1>
                <p>Entrez vos données personnelles pour utiliser notre service.</p>
                <button class="ghost" id="signUp">Créer un compte</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
