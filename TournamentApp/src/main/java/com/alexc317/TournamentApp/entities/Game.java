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
public class Game {

    private int ID;
    private String gameName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.ID;
        hash = 53 * hash + Objects.hashCode(this.gameName);
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
        final Game other = (Game) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.gameName, other.gameName)) {
            return false;
        }
        return true;
    }

}
