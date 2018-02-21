package com.controller;

import com.dao.CRUDOperation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        int sroll = Integer.parseInt(req.getParameter("roll"));
        int a = CRUDOperation.deleteData(sroll);
         if(a>0){
            pw.println("<h1 style='color:green'>Delete Successfull</h1>");
            RequestDispatcher request = req.getRequestDispatcher("/retriveservlet");
            request.include(req, resp);
        }else{
            pw.println("<h1>Delete Failed</h1>"); 
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

}
