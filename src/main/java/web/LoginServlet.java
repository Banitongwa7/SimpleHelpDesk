package web;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.lesBeans;
import database.LoginDao;

/**
 * @email Ramesh Fadatare
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("txtName");
        String email = request.getParameter("txtEmail");
        String service = request.getParameter("typeService");
        String phone = request.getParameter("txtPhone");
        String typeAppareil = request.getParameter("typeApp");
        String message = request.getParameter("txtMessage");
        lesBeans bean = new lesBeans();
        bean.setNom(nom);
        bean.setEmail(email);
        bean.setService(service);
        bean.setPhone(phone);
        bean.setTypeAppareil(typeAppareil);
        bean.setMessage(message);

        try {
            if (loginDao.insert(bean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("index.jsp");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //doGet(request, response);
    }
/*
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        String action = request.getAttribute("delete_t").toString();

        try {
            switch (action) {
                case "delete_t":
                    delete(request, response);
                    break;
                default:
                    System.out.println("Default");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("idcheck"));
        lesBeans bean = new lesBeans(id);
        try {
            boolean del = loginDao.delete(bean);
            if(del)
            {
                request.getRequestDispatcher("ticket_listing.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

 */
}