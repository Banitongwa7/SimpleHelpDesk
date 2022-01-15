<%--
  Created by IntelliJ IDEA.
  User: davidb
  Date: 11/01/2022
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- CSS -->
  <link rel="stylesheet" href="style.css">

  <title>HelpDesk | Home</title>
</head>
<body>
<div class="container contact-form">
  <div class="contact-image">
    <img src="image2.png" alt="rocket_contact"/>
  </div>
  <form action="<%=request.getContextPath()%>/login" method="post">
    <h3>Obtenez votre ticket en remplissant ce formulaire</h3>
    <div class="row">
      <div class="col-md-6">
        <div class="form-group">
          <input type="text" name="txtName" class="form-control" placeholder="Nom complet" value="" />
        </div>
        <div class="form-group">
          <input type="email" name="txtEmail" class="form-control" placeholder="Email" value="" />
        </div>
        <div class="form-group">
          <select class="form-select  form-control" name="typeService">
            <option selected>Type de service</option>
            <option value="Reparation">Réparation</option>
            <option value="Diagnostic">Diagnostic</option>
            <option value="Renseignement">Renseignement</option>
          </select>
        </div>
      </div>

      <div class="col-md-6">
        <div class="form-group">
          <input type="tel" name="txtPhone" class="form-control" placeholder="Numero Téléphone"/>
        </div>
        <div class="form-group">
          <select class="form-select  form-control" name="typeApp">
            <option selected>Type d'appareil</option>
            <option value="Ordinateur">Ordinateur</option>
            <option value="Smartphone">Smartphone</option>
            <option value="Tablette">Tablette</option>
          </select>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="form-group mt-5">
                    <textarea name="txtMessage" class="form-control" placeholder="Votre message"
                              style="width: 100%; height: 150px;"></textarea>
      </div>
      <div class="form-group my-5 text-center">
        <input type="submit" name="btnSubmit" class="btnContact" value="Obtenir ticket" />
      </div>
    </div>
  </form>
  <a href="ticket_listing.jsp" class="btn btn-primary mt-3">Voir les ticket</a>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
