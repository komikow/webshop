package by.it.academy.controllers;

import by.it.academy.services.ProductService;
import by.it.academy.services.ProductServiceImpl;
import lombok.RequiredArgsConstructor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.entities.Constants.PRODUCTS_PAGE;
import static by.it.academy.entities.Constants.PRODUCT_READ;

@RequiredArgsConstructor
<<<<<<< HEAD
@WebServlet(urlPatterns = {PRODUCT_READ}, loadOnStartup = 0)
=======
@WebServlet(urlPatterns = {PRODUCT_URL_READ})
>>>>>>> 3c6d791 (add fixed error code)
public class SelectProductController extends HttpServlet {
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
<<<<<<< HEAD
        req.setAttribute("products", productService.readProduct());
        req.getRequestDispatcher(PRODUCTS_PAGE)
                .forward(req, resp);
=======
        req.setAttribute(PRODUCTS, productService.readProduct());
        req.getRequestDispatcher(PRODUCTS_PAGE).forward(req, resp);
>>>>>>> 3c6d791 (add fixed error code)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
<<<<<<< HEAD
        productService = (ProductServiceImpl) config.getServletContext()
                .getAttribute("productService");
=======
        productService = (ProductServiceImpl) config
                .getServletContext()
                .getAttribute(PRODUCT_SERVICE);
>>>>>>> 3c6d791 (add fixed error code)
    }
}
