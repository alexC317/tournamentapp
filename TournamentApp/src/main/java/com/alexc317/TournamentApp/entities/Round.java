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

    private int roundID;
    private Player roundPlayer1;
    private Player roundPlayer2;
    private boolean isP1Winner;

    public int getRoundID() {
        return roundID;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public Player getRoundPlayer1() {
        return roundPlayer1;
    }

    public void setRoundPlayer1(Player roundPlayer1) {
        this.roundPlayer1 = roundPlayer1;
    }

    public Player getRoundPlayer2() {
        return roundPlayer2;
    }

    public void setRoundPlayer2(Player roundPlayer2) {
        this.roundPlayer2 = roundPlayer2;
    }

    public boolean isIsP1Winner() {
        return isP1Winner;
    }

    public void setIsP1Winner(boolean isP1Winner) {
        this.isP1Winner = isP1Winner;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.roundID;
        hash = 47 * hash + Objects.hashCode(this.roundPlayer1);
        hash = 47 * hash + Objects.hashCode(this.roundPlayer2);
        hash = 47 * hash + (this.isP1Winner ? 1 : 0);
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
        if (this.roundID != other.roundID) {
            return false;
        }
        if (this.isP1Winner != other.isP1Winner) {
            return false;
        }
        if (!Objects.equals(this.roundPlayer1, other.roundPlayer1)) {
            return false;
        }
        if (!Objects.equals(this.roundPlayer2, other.roundPlayer2)) {
            return false;
        }
        return true;
    }

}
