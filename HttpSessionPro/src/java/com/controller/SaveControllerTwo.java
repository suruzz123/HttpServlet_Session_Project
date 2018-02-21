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
import javax.servlet.http.HttpSession;

public class SaveControllerTwo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String sdepartment = req.getParameter("department");
        String ssession = req.getParameter("session");
        String scountry = req.getParameter("country");
        HttpSession session = req.getSession();
        
        int sroll = (Integer)session.getAttribute("sroll");
        String sname =(String) session.getAttribute("sname");
        String seamil =(String) session.getAttribute("seamil");
        
        Student obj = new Student(sroll,sname,seamil,sdepartment,ssession,scountry);
        
        int a = CRUDOperation.insertData(obj);
        if(a>0){
            pw.println("<h1 style='color:green'>Insert Successfull</h1>");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        }else{
             pw.println("<h1 style='color:red'>Insert Failed</h1>");
        }
    }

}
