// File: src/main/java/com/example/demo/servlet/SimpleStatusServlet.java
package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * STEP 0 - Servlet Requirement
 */
@WebServlet(urlPatterns = "/simple-status")
public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        try (PrintWriter pw = resp.getWriter()) {
            // EXACT body expected by tests (no extra whitespace/newline)
            pw.write("Cold Chain Temperature Breach Alert System is running");
            pw.flush();
        }
    }
}