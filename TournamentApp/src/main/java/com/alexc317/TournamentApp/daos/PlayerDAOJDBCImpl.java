/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Player;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class PlayerDAOJDBCImpl implements PlayerDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_PLAYER = "INSERT INTO Player(firstName, lastName, gamertag) VALUES (?, ?, ?)";
    private final String SELECT_ALL_PLAYERS = "SELECT firstName, lastName, gamertag FROM Player";
    private final String SELECT_PLAYER_BY_ID = "SELECT firstName, lastName, gamertag FROM Player WHERE ID = ?";
    private final String EDIT_PLAYER = "UPDATE Player SET firstName = ?, lastName = ?, gamertag = ? WHERE ID = ?";
    private final String DELETE_PLAYER = "DELETE FROM Player WHERE ID = ?";

    @Override
    public Player addPlayer(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Player> getAllPlayers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player getPlayer(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editPlayer(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePlayer(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
