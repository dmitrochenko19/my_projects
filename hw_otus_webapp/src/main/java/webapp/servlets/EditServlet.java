package webapp.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import webapp.entilities.User;
import webapp.model.ModelDB;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet", value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/view/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelDB modelDB = new ModelDB();
        String oldName =request.getParameter("old_name");
        String newName = request.getParameter("name");
        String birthDate = request.getParameter("date");
        String sex = request.getParameter("sex");
        try{
        User user = new User(newName,birthDate,sex);
            modelDB.updateUser(oldName,user.getName(), user.getBirthDateSQL(), user.getSex(), user.getAge());
             response.sendRedirect("form");
        }
        catch (Exception e){
            response.sendRedirect("view/exception.jsp");
        }

    }
}
