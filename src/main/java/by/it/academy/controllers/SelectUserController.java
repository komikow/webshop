package by.it.academy.controllers;

<<<<<<< HEAD
=======
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;
>>>>>>> 3c6d791 (add fixed error code)
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

<<<<<<< HEAD
import static by.it.academy.entities.Constants.USER_READ;

@RequiredArgsConstructor
@WebServlet(urlPatterns = {USER_READ})
public class SelectUserController extends HttpServlet {
    private UserService userService;
=======
import static by.it.academy.entities.Constants.*;

@RequiredArgsConstructor
@WebServlet(urlPatterns = {USER_URL_READ}, loadOnStartup = -1)
public class SelectUserController extends HttpServlet {
    private UserService userService;
    private UserRepository userRepository;
>>>>>>> 3c6d791 (add fixed error code)

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
<<<<<<< HEAD
        req.setAttribute("users", userService.readUsers());
        req.getRequestDispatcher("/pages/user/users.jsp")
                .forward(req, resp);
=======
        req.setAttribute(USERS, userRepository.readUsers());
        req.setAttribute(USERS, userService.readUsers());
        req.getRequestDispatcher(ALL_USERS_PAGE).forward(req, resp);
>>>>>>> 3c6d791 (add fixed error code)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

<<<<<<< HEAD
        @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext()
                .getAttribute("userService");
=======
    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config
                .getServletContext()
                .getAttribute(USER_SERVICE);
        userRepository = (UserRepositoryImpl) config
                .getServletContext()
                .getAttribute(USER_REPOSITORY);
>>>>>>> 3c6d791 (add fixed error code)
    }
}
