/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GameDAOJDBCImpl implements GameDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_GAME = "INSERT INTO Game(gameName) VALUES(?)";
    private final String SELECT_ALL_GAMES = "SELECT ID, gameName FROM Game";
    private final String SELECT_GAME_BY_ID = "SELECT ID, gameName FROM Game WHERE ID = ?";
    private final String UPDATE_GAME = "UPDATE Game SET gameName = ? WHERE ID = ?";
    private final String DELETE_GAME = "DELETE FROM Game WHERE ID = ?";

    @Override
    public Game addGame(Game game) {
        jdbc.update(INSERT_NEW_GAME, game.getGameName());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setID(newID);
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game getGame(int ID) {
        return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), ID);
    }

    @Override
    public void updateGame(Game game) {
        jdbc.update(UPDATE_GAME, game.getGameName(), game.getID());
    }

    @Override
    public void deleteGame(int ID) {
        jdbc.update(DELETE_GAME, ID);
    }

    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int i) throws SQLException {
            Game game = new Game();
            game.setID(rs.getInt("ID"));
            game.setGameName(rs.getString("gameName"));
            return game;
        }

    }

}
