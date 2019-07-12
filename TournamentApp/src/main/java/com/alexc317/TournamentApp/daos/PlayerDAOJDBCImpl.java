/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository

public class PlayerDAOJDBCImpl implements PlayerDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_PLAYER = "INSERT INTO Player(firstName, lastName, gamertag) VALUES (?, ?, ?)";
    private final String SELECT_ALL_PLAYERS = "SELECT ID, firstName, lastName, gamertag FROM Player";
    private final String SELECT_PLAYER_BY_ID = "SELECT ID, firstName, lastName, gamertag FROM Player WHERE ID = ?";
    private final String EDIT_PLAYER = "UPDATE Player SET firstName = ?, lastName = ?, gamertag = ? WHERE ID = ?";
    private final String DELETE_PLAYER = "DELETE FROM Player WHERE ID = ?";

    @Override
    public Player addPlayer(Player player) {
        jdbc.update(INSERT_NEW_PLAYER, player.getFirstName(), player.getLastName(), player.getGamertag());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        player.setID(newID);
        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        return jdbc.query(SELECT_ALL_PLAYERS, new PlayerMapper());
    }

    @Override
    public Player getPlayer(int ID) {
        return jdbc.queryForObject(SELECT_PLAYER_BY_ID, new PlayerMapper(), ID);
    }

    @Override
    public void editPlayer(Player player) {
        jdbc.update(EDIT_PLAYER, player.getFirstName(), player.getLastName(), player.getGamertag(), player.getID());
    }

    @Override
    public void deletePlayer(int ID) {
        jdbc.update(DELETE_PLAYER, ID);
    }

    public static final class PlayerMapper implements RowMapper<Player> {

        @Override
        public Player mapRow(ResultSet rs, int i) throws SQLException {
            Player player = new Player();
            player.setID(rs.getInt("ID"));
            player.setFirstName(rs.getString("firstName"));
            player.setLastName(rs.getString("lastName"));
            player.setGamertag((rs.getString("gamertag")));

            return player;
        }

    }

}
