package com.naldojesse.web.models;

import java.util.ArrayList;


public class Team implements java.io.Serializable {
    private String team_name;
    private ArrayList<Player> players;

    public Team() {
        team_name = null;
        players = new ArrayList<Player>();
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
