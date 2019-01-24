package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team> {
    List<T> teams;

    public League() {
        this.teams = new ArrayList<>();
    }

    public boolean addTeam(T team) {
        if (teams.contains(team)) {
            System.out.println("That team is already in the league");
            return false;
        }
        teams.add(team);
        return true;
    }

    public void showTeams() {
        sortTeamsByWins();
        for (T team : teams) {
            System.out.println(team.getName() + ": " + team.getWins() + " wins");
        }
    }

    private void sortTeamsByWins() {
        Collections.sort(teams);
    }
}
