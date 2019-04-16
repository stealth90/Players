package com.player;

import java.util.ArrayList;

public class Team {
    private String name;
    private int yearOfFoundation;
    private int numberOfPlayer;
    private ArrayList<Player> players;

    public Team(String name, int yearOfFoundation) {
        this.name = name;
        this.yearOfFoundation = yearOfFoundation;
        this.numberOfPlayer = 0;
        this.players = new ArrayList<>();
    }

    public void addPlayer (Player player) {
        players.add(player);
        this.numberOfPlayer++;
    }

    public ArrayList<Player> findPlayerByName (String name) {
        ArrayList<Player> foundPlayer = new ArrayList<>();

        for(int i = 0; i < this.numberOfPlayer; i++)
            if(players.get(i).getName().equalsIgnoreCase(name) || players.get(i).getSurname().equalsIgnoreCase(name))
                foundPlayer.add(players.get(i));

        return foundPlayer;
    }

    public ArrayList<Player> findPlayerByRole (String role) {
        ArrayList<Player> foundPlayer = new ArrayList<>();

        for(int i = 0; i < this.numberOfPlayer; i++)
            if(players.get(i).getRole().equalsIgnoreCase(role))
                foundPlayer.add(players.get(i));

        return foundPlayer;
    }

    public String getName() {
        return name;
    }
}
