package webapp.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import webapp.model.ModelDB;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelDB modelDB = new ModelDB();
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String date = request.getParameter("date");
        try {
            modelDB.deleteUser(name, sex, date);
            response.sendRedirect("form");
        }catch (Exception e){
            response.sendRedirect("view/exception.jsp");
        }
    }
}
