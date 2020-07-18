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
public class Player {

    private int playerID;
    private String playerFirstName;
    private String playerLastName;
    private String playerDisplayName;

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public String getPlayerDisplayName() {
        return playerDisplayName;
    }

    public void setPlayerDisplayName(String playerDisplayName) {
        this.playerDisplayName = playerDisplayName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.playerID;
        hash = 67 * hash + Objects.hashCode(this.playerFirstName);
        hash = 67 * hash + Objects.hashCode(this.playerLastName);
        hash = 67 * hash + Objects.hashCode(this.playerDisplayName);
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
        final Player other = (Player) obj;
        if (this.playerID != other.playerID) {
            return false;
        }
        if (!Objects.equals(this.playerFirstName, other.playerFirstName)) {
            return false;
        }
        if (!Objects.equals(this.playerLastName, other.playerLastName)) {
            return false;
        }
        if (!Objects.equals(this.playerDisplayName, other.playerDisplayName)) {
            return false;
        }
        return true;
    }

}
