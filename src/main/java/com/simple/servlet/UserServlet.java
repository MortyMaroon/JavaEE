package com.simple.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "JdbcServlet", urlPatterns = "/jdbc_servlet")
public class UserServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(UserServlet.class);
    private Connection connection;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get all tables");
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SHOW TABLES;");
            while (rs.next()) {
                String tableName = rs.getString(0);
                resp.getWriter().println("<p> " + tableName + " </p>");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        connection = (Connection) context.getAttribute("jdbcConnection");

        if (connection == null) {
            throw  new ServletException("No JDBC connection is Servlet Context");
        }
    }
}
