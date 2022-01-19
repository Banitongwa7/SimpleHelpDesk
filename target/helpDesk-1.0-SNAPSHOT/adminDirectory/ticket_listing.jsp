<%@ page import="java.sql.*" %>
<%@ page import="com.mysql.cj.jdbc.result.ResultSetImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: davidb
  Date: 11/01/2022
  Time: 17:05
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
    <title>HelpDesk | Ticket</title>
</head>
<body>
<div class="container">
    <h2 class="text-center mt-5">Liste des Tickets</h2>

    <table class="table table-hover table-primary mt-5">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nom Complet</th>
            <th scope="col">Email</th>
            <th scope="col">Numero Telephone</th>
            <th scope="col">Type d'appareil</th>
            <th scope="col">Type de service</th>
            <th scope="col">Message</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <% try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/helpdesk?serverTimezone=UTC", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("Select * from ticket");
            while(rset.next())
            {%>
                <tr>
                    <th scope="row"><%= rset.getInt("id") %></th>
                    <td><%= rset.getString("nom") %></td>
                    <td><%= rset.getString("email") %></td>
                    <td><%= rset.getString("phone") %></td>
                    <td><%= rset.getString("typeAppareil") %></td>
                    <td><%= rset.getString("service") %></td>
                    <td><%= rset.getString("message") %></td>
                    <td><a href="delete?id=<%= rset.getInt("id") %>"><input type="button" name="delete_t" value="Traiter" class="btn btn-success"/></a></td>
                </tr>
        <%
            }

            rset.close();
            stmt.close();
            conn.close();
        }

        catch(SQLException e1){
            System.out.println(e1.getMessage());
        }

        catch(ClassNotFoundException e2){
            System.out.println(e2.getMessage());
        }
        %>

        </tbody>
    </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
