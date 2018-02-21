package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveControllerOne extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sroll = Integer.parseInt(req.getParameter("roll"));
        String sname = req.getParameter("name");
        String seamil = req.getParameter("email");

        HttpSession session = req.getSession();
        session.setAttribute("sroll", sroll);
        session.setAttribute("sname", sname);
        session.setAttribute("seamil", seamil);
        resp.sendRedirect("next.html");
    }

}
