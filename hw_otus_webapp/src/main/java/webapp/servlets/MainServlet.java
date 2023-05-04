package webapp.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import webapp.entilities.User;
import webapp.model.ModelDB;

import java.io.IOException;
import java.util.List;

//@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelDB modelDB = new ModelDB();
        List<User> users = null;
        try {
            users = modelDB.getUsers();
        }catch (Exception e){}
        request.setAttribute("users",users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/form.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String name = request.getParameter("name");
        String birthDate = request.getParameter("date");
        String sex = request.getParameter("sex");
        try {
            User user = new User(name, birthDate, sex);
            ModelDB modelDB = new ModelDB();
            modelDB.addUser(user);
        }catch (Exception e){
            response.sendRedirect("view/exception.jsp");
            return;
        }

        doGet(request,response);

    }
}
