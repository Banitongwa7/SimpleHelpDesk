package web;

import bean.loginBeans;
import database.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

        public AdminServlet()
        {
            super();
        }

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.getWriter().append("served at: ").append(req.getContextPath());
        }

        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            loginBeans loginbean = new loginBeans();
            loginbean.setUsername(username);
            loginbean.setPassword(password);

            Dao connect = new Dao();

            if(connect.loginAdmin(loginbean))
            {
                resp.sendRedirect("ticket_listing.jsp");
            }
            else
            {
                resp.sendRedirect("admin_login.jsp");
            }
        }
}
