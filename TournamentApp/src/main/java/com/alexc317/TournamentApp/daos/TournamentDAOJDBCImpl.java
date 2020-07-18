/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Tournament;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TournamentDAOJDBCImpl implements TournamentDAO {
    
    @Autowired
    private JdbcTemplate jdbc;
    
    private final String INSERT_NEW_TOURNAMENT = "";
    private final String SELECT_ALL_TOURNAMENTS = "";
    private final String SELECT_TOURNAMENT_BY_ID = "";
    private final String UPDATE_TOURNAMENT = "";
    private final String DELETE_TOURNAMENT = "";

    @Override
    public Tournament addTournament(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tournament> getAllTournaments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tournament getTournamentByID(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTournament(Tournament tournament) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTournament(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
