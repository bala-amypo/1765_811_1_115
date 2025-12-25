// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.annotation.WebServlet;
// import java.io.IOException;

// @WebServlet(urlPatterns = "/simple-status")
// public class SimpleStatusServlet extends HttpServlet {

//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         resp.setStatus(200);
//         resp.getWriter().write("Cold Chain Temperature Breach Alert System is running");
//     }
// }
package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/simple-status")
public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write(
            "Cold Chain Temperature Breach Alert System is running"
        );
        resp.getWriter().flush();
    }
}
