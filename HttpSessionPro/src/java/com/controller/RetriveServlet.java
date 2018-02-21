package com.controller;

import com.dao.CRUDOperation;
import com.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetriveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        List<Student> list = CRUDOperation.retriveData();
        pw.println("<html><head><title>Show Data</title></head>");
        pw.println("<body>");
        pw.println("<table border='1'>");
        pw.println("<caption>Student Information</caption>");
        pw.println("<tr><th>Roll</th><th>Name</th><th>E-mail</th><th>Department</th>"
                + "<th>Session</th><th>Country</th><th>Edit Data</th><th>Delete Data</th></tr>");
        for (Student s : list) {
            pw.println("<tr><td>" + s.getRoll() + "</td><td>" + s.getName() + "</td><td>" + s.getEmail() + "</td><td>" + s.getDepartment() + "</td><td>" + s.getSession() + "</td>"
                    + "<td>" + s.getCountry() + "</td><td><a href='editservlet?roll=" + s.getRoll() + "'>Edit</a></td><td><a href='deleteservlet?roll=" + s.getRoll() + "'>Delete</a></td>");
        }
        pw.println("</table>");
        pw.println("<a href ='index.html'>Go To Home Page</a>");
        pw.println("</body></html>");
    }

}
