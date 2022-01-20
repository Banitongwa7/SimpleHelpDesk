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
<%@ page import="database.Dao" %>
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
<% Dao nbr = new Dao(); %>
<div class="container">
    <h2 class="text-center mt-5">Espace Administrateur</h2>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-8">
            <div class="main-content">
                <div class="page-content">
                    <!-- end page title -->
                    <div class="row">
                        <div class="col-md-6 col-xl-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="float-end mt-2">
                                        <div id="total-revenue-chart"></div>
                                    </div>
                                    <div>
                                        <h4 class="mb-1 mt-1"><span data-plugin="counterup"><%= nbr.nombreUser() %></span></h4>
                                        <p class="text-muted mb-0">Nombre d'utilisateur</p>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- end col-->
                        <div class="col-md-6 col-xl-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="float-end mt-2">
                                        <div id="orders-chart"> </div>
                                    </div>
                                    <div>
                                        <h4 class="mb-1 mt-1"><span data-plugin="counterup"><%= nbr.nombreTicket() %></span></h4>
                                        <p class="text-muted mb-0">Tickets </p>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- end col-->
                        <div class="col-md-6 col-xl-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="float-end mt-2">
                                        <div id="customers-chart"> </div>
                                    </div>
                                    <div>
                                        <h4 class="mb-1 mt-1"><span data-plugin="counterup"><%= nbr.nombreAdmin() %></span></h4>
                                        <p class="text-muted mb-0">Administrateurs</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- end col-->
                    </div>
                </div>
            </div>
        </div>
    </div>

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

<!-- JAVASCRIPT -->
<script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
<script src="assets/libs/jquery/jquery.min.js"></script>
<script src="assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/libs/metismenu/metisMenu.min.js"></script>
<script src="assets/libs/simplebar/simplebar.min.js"></script>
<script src="assets/libs/node-waves/waves.min.js"></script>
<script src="assets/libs/waypoints/lib/jquery.waypoints.min.js"></script>
<script src="assets/libs/jquery.counterup/jquery.counterup.min.js"></script>

<!-- apexcharts -->
<script src="assets/libs/apexcharts/apexcharts.min.js"></script>
<script src="assets/js/pages/dashboard.init.js"></script>
<!-- App js -->
<script src="assets/js/app.js"></script>
</body>
</html>
