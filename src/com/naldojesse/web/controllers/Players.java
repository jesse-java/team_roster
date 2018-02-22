package com.naldojesse.web.controllers;

import com.naldojesse.web.models.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import com.naldojesse.web.models.*;

@WebServlet("/rosters/players")
public class Players extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<Team> cTeams = (ArrayList<Team>) session.getAttribute("sTeams");

        int vTeamID = Integer.parseInt(request.getParameter("team_id"));
        Team vTeam = cTeams.get(vTeamID);

        //error message handling
        ArrayList<String> error_messages = new ArrayList<>();

        if (request.getParameter("first_name").length() == 0) {
            error_messages.add("First name must not be blank");
        }
        if (request.getParameter("last_name").length() == 0) {
            error_messages.add("Last name must not be blank");
        }
        if (Integer.parseInt(request.getParameter("age")) < 18) {
            error_messages.add("You must be a minimum of 18 years old to join");
        }

        if (error_messages.size() != 0) {
            request.setAttribute("error_messages", error_messages);
            request.setAttribute("vTeam", vTeam);
            request.setAttribute("team_id", vTeamID);
            request.getRequestDispatcher("/WEB-INF/add_player.jsp").forward(request, response);
        } else {

            ArrayList<Player> cPlayers = vTeam.getPlayers();

            //when user presses delete button on player
            if (request.getParameter("action") != null) {
                if(request.getParameter("action").equals("delete")) {
                    cPlayers.remove(Integer.parseInt(request.getParameter("player_id")));
                }
            } else {

                Player nplayer = new Player(request.getParameter("first_name"), request.getParameter("last_name"), Integer.parseInt(request.getParameter("age")));

                cPlayers.add(nplayer);
            }


            response.sendRedirect("/rosters/teams?id="+ vTeamID);


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        ArrayList<Team> cTeams = (ArrayList<Team>) session.getAttribute("sTeams");

        int vTeamID = Integer.parseInt(request.getParameter("id"));
        Team vTeam = cTeams.get(vTeamID);
        request.setAttribute("vTeam", vTeam);
        request.setAttribute("team_id", request.getParameter("id"));

        request.getRequestDispatcher("/WEB-INF/add_player.jsp").forward(request,response);
    }
}
