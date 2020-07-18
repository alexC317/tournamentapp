/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Tournament;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface TournamentDAO {

    public Tournament addTournament(Tournament tournament);

    public List<Tournament> getAllTournaments();

    public Tournament getTournamentByID(int ID);

    public void updateTournament(Tournament tournament);

    public void deleteTournament(int ID);

}
