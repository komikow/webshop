package by.it.academy.controllers;

import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.entities.Constants.USER_READ;

@RequiredArgsConstructor
@WebServlet(urlPatterns = {USER_READ})
public class SelectUserController extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("users", userService.readUsers());
        req.getRequestDispatcher("/pages/user/users.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

        @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext()
                .getAttribute("userService");
    }
}
