package web;


import bean.signupBeans;
import database.Dao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    public SignupServlet()
    {
        super();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("served at: ").append(req.getContextPath());
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nomNew");
        String prenom = req.getParameter("prenomNew");
        String email = req.getParameter("emailNew");
        String password = req.getParameter("passwordNew");

        signupBeans signup = new signupBeans();
        signup.setNom(nom);
        signup.setPrenom(prenom);
        signup.setEmail(email);
        signup.setPassword(password);

        Dao connect = new Dao();

        try {
            if(connect.newUser(signup))
            {
                resp.sendRedirect("ticket.jsp");
            }
            else
            {
                resp.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
