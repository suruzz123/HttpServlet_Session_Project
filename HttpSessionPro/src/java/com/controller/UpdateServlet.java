package com.controller;

import com.dao.CRUDOperation;
import com.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        int sroll = Integer.parseInt(req.getParameter("roll"));
        String sname = req.getParameter("name");
        String seamil = req.getParameter("email");
        String sdepartment = req.getParameter("department");
        String ssession = req.getParameter("session");
        String scountry = req.getParameter("country");
        
        Student std = new Student(sroll, sname, seamil, sdepartment, ssession, scountry);
        int a = CRUDOperation.updateData(std);
        if(a>0){
            pw.println("<h1 style='color:green'>Update Successfull</h1>");
            RequestDispatcher request = req.getRequestDispatcher("/retriveservlet");
            request.include(req, resp);
        }else{
            pw.println("<h1>Update Failed</h1>"); 
        }
    }

}
