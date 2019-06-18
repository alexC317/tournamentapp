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
public class Round {

    private int ID;
    private Player player1;
    private Player player2;
    private boolean p1Winner;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isP1Winner() {
        return p1Winner;
    }

    public void setP1Winner(boolean p1Winner) {
        this.p1Winner = p1Winner;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.ID;
        hash = 47 * hash + Objects.hashCode(this.player1);
        hash = 47 * hash + Objects.hashCode(this.player2);
        hash = 47 * hash + (this.p1Winner ? 1 : 0);
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
        final Round other = (Round) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.p1Winner != other.p1Winner) {
            return false;
        }
        if (!Objects.equals(this.player1, other.player1)) {
            return false;
        }
        if (!Objects.equals(this.player2, other.player2)) {
            return false;
        }
        return true;
    }

}
