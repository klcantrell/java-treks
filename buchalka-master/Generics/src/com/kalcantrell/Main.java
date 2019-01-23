package com.kalcantrell;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Intro.run();

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        // adelaideCrows.addPlayer(pat); // error because not football players
        // adelaideCrows.addPlayer(beckham); // error because not football players

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        // without bounded type declaration, this won't work
        //Team<String> brokenTeam = new Team<>("this won't work");
        //brokenTeam.addPlayer("no-one");



    }



}
