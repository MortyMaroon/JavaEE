package com.simple.servlet;

import com.simple.utils.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        resp.getWriter().printf("<h1>%s</h1>", createProducts());


    }

    private String createProducts() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            builder.append("<h1>" +
                    new Product(i,"title" + i, i*i).toString() +
                    "</h1>\n");
        }
        return builder.toString();
    }
}
