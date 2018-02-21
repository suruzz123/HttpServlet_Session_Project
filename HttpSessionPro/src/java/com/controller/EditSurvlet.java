package com.controller;

import com.dao.CRUDOperation;
import com.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditSurvlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        int sroll = Integer.parseInt(req.getParameter("roll"));
        Student std = CRUDOperation.readSingleData(sroll);
        pw.println("<html><head><title>Edit Page</title></head><body>");
        pw.println("<h1 style='color:pink'>For Edit: </h1><form action='updateservlet' method='get'>");
        pw.println("<table>");
        pw.println("<tr><td>Roll : </td><td><input type='text' name='roll' value='" + std.getRoll() + "'/></td></tr>");
        pw.println("<tr><td>Name : </td><td><input type='text' name='name' value='" + std.getName() + "'/></td></tr>");
        pw.println("<tr><td>E-mail : </td><td><input type='text' name='email' value='" + std.getEmail() + "'/></td></tr>");
        pw.println("<tr><td>Department : </td><td><input type='text' name='department' value='" + std.getDepartment() + "'/></td></tr>");
        pw.println("<tr><td>Session : </td><td><input type='text' name='session' value='" + std.getSession() + "'/></td></tr>");
        pw.println("<tr><td>Country : </td><td><input type='text' name='country' value='" + std.getCountry() + "'/></td></tr>");
        pw.println("<tr><td></td><td><input type='submit' value='Edit & Save'/></td></tr>");
        pw.println("</table></form></body></html>");
    }

}
