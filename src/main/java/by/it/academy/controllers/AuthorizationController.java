package by.it.academy.controllers;

import by.it.academy.entities.UserType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//@WebServlet(urlPatterns = {"/user/create"})
//по нажатии на кнопку create должна открываться страница админа или страница юзера
//
public class AuthorizationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //получаем логин и пароль
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        //открываем сессию
        HttpSession session = req.getSession(true);
        if (null != session.getAttribute("userType")) {
            //получаем тип атрибута - ADMIN или USER
            Object userType = (UserType)session.getAttribute("userType");
            if (userType == UserType.ADMIN) {
                req.getRequestDispatcher("/pages/staff/adminPage.jsp");
            } else {
                req.getRequestDispatcher("/pages/staff/userPage.jsp")
                        .forward(req, resp);
            }
        }
    }
}
