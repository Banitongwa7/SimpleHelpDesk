package web;

import bean.lesBeans;
import database.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Dao dao;

    public void init() {
        dao = new Dao();
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
            if (dao.insert(bean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("ticket.jsp");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
