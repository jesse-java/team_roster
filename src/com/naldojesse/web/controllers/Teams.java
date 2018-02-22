package com.naldojesse.web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.naldojesse.web.models.Team;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

@WebServlet("/rosters/teams")
public class Teams extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String team_name = request.getParameter("team_name");
        System.out.println(team_name);

        Team nTeam =  new Team(team_name);

        ArrayList<Team> cTeams = (ArrayList<Team>) session.getAttribute("sTeam");

        cTeams.add(nTeam);

        response.sendRedirect("/home");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/create_team.jsp").forward(request, response);

    }
}
