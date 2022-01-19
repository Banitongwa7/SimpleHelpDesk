package web;

import bean.lesBeans;
import database.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            String idTemp = request.getParameter("id");
            int id = Integer.parseInt(idTemp);
            lesBeans bean = new lesBeans(id);
            Dao da = new Dao();
            boolean test = false;
            try {
                test = da.delete(bean);
                if (test)
                {
                    response.sendRedirect("ticket_listing.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }


        @Override
        public String getServletInfo() {
            return "Short description";
        }

    }
