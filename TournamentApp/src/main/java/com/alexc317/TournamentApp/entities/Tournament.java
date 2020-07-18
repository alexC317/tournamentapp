/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.entities;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Tournament {

    private int tournamentID;
    private Game game;
    private int eventID;

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.tournamentID;
        hash = 97 * hash + Objects.hashCode(this.game);
        hash = 97 * hash + this.eventID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tournament other = (Tournament) obj;
        if (this.tournamentID != other.tournamentID) {
            return false;
        }
        if (this.eventID != other.eventID) {
            return false;
        }
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        return true;
    }

}
