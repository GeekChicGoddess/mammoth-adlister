package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println(username + " " + password + " " + email);

        if ((username != null) && (password != null) && (email != null)) {
            User user = new User(
                    username,
                    email,
                    password
            );
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
        }



        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
    }
}
