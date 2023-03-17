package by.it.academy.controllers;

import by.it.academy.services.ProductService;
import by.it.academy.services.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.entities.Constants.*;

@WebServlet(urlPatterns = {PRODUCT_URL_CREATE}, loadOnStartup = 0)
public class CreateProductController extends HttpServlet {
    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter(PRODUCT_MODEL);
        String specifications = req.getParameter(PRODUCT_SPECIFICATIONS);
        int guarantee = Integer.parseInt(req.getParameter(PRODUCT_GUARANTEE));
        int price = Integer.parseInt(req.getParameter(PRODUCT_PRICE));
        int quantity = Integer.parseInt(req.getParameter(PRODUCT_QUANTITY));
        productService.createProduct(model, specifications, guarantee, price, quantity);
        req.getRequestDispatcher(PRODUCT_ADD_TRUE_PAGE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        productService = (ProductServiceImpl) config
                .getServletContext()
                .getAttribute(PRODUCT_SERVICE);
    }
}
