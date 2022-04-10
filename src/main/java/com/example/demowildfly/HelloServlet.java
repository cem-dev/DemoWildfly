package com.example.demowildfly;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
        System.out.println("Initialized!!");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Resource(lookup="java:/MySqlDS")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        final PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Test</h1>");
        try {
            final Connection con = ds.getConnection();
            if (con.isValid(10))
                out.println("<BR>Connected via @Resource!");
            con.close();
        } catch (Exception ex) {
            out.println(ex.getMessage()+"\n");
            ex.printStackTrace(out);
        }
        out.println("</body></html>");
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    public void destroy() {
    }
}