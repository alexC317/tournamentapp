/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Round;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface RoundDAO {

    public Round addRound(Round round);

    public List<Round> getAllRounds();

    public Round getRoundByID(int ID);

    public void updateRound(Round round);

    public void deleteRound(int ID);
}
