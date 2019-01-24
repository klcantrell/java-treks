package com.app;

public class Team implements Comparable<Team> {
    String name;
    int wins;

    public Team(String name, int wins) {
        this.name = name;
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int compareTo(Team opponent) {
        if (this.getWins() > opponent.getWins()) {
            return -1;
        } else if (this.getWins() < opponent.getWins()) {
            return 1;
        } else {
            return 0;
        }
    }
}
