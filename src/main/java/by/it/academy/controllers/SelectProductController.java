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
@WebServlet(urlPatterns = {PRODUCT_READ}, loadOnStartup = 0)
public class SelectProductController extends HttpServlet {
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("products", productService.readProduct());
        req.getRequestDispatcher(PRODUCTS_PAGE)
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService = (ProductServiceImpl) config.getServletContext()
                .getAttribute("productService");
    }
}
