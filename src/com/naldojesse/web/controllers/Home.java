package com.naldojesse.web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import com.naldojesse.web.models.*;

@WebServlet(name="HomeController", urlPatterns={"", "/rosters/home"})
public class Home extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Team> cTeams;

        HttpSession session = request.getSession();

        if (session.getAttribute("sTeams") == null) {
            session.setAttribute("sTeams", new ArrayList<Team>());
        }

        cTeams = (ArrayList<Team>) session.getAttribute("sTeams");


        request.setAttribute("cTeams", cTeams);

        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);



    }
}
