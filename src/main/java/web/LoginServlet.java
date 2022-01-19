package web;

import bean.loginBeans;
import database.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public LoginServlet()
    {
        super();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("served at: ").append(req.getContextPath());
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        loginBeans loginbean = new loginBeans();
        loginbean.setEmail(email);
        loginbean.setPassword(password);

        Dao connect = new Dao();

        if(connect.loginUser(loginbean))
        {
            resp.sendRedirect("ticket.jsp");
        }
        else
        {
            resp.sendRedirect("index.jsp");
        }

    }
}