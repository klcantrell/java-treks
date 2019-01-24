package com.app;

public class Main {

    public static void main(String[] args) {
        League<FootballTeam> footballLeague = new League<>();
        FootballTeam footballTeamA = new FootballTeam("Football Team A", 30);
        FootballTeam footballTeamB = new FootballTeam("Football Team B", 40);
        FootballTeam footballTeamC = new FootballTeam("Football Team C", 50);

        BasketballTeam basketballTeamA = new BasketballTeam("Basketball Team A", 50);

        footballLeague.addTeam(footballTeamA);
        footballLeague.addTeam(footballTeamB);
        footballLeague.addTeam(footballTeamC);
        //footballLeague.addTeam(basketballTeamA);

        footballLeague.showTeams();
    }
}
