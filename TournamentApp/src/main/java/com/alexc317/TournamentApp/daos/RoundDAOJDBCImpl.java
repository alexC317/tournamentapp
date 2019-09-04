/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.daos.PlayerDAOJDBCImpl.PlayerMapper;
import com.alexc317.TournamentApp.entities.Player;
import com.alexc317.TournamentApp.entities.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RoundDAOJDBCImpl implements RoundDAO {

    @Autowired
    private JdbcTemplate jdbc;

    private final String INSERT_NEW_ROUND = "INSERT INTO Round(player1ID, player2ID, p1Winner) VALUES(?, ?, ?)";
    private final String SELECT_ALL_ROUNDS = "SELECT ID, player1ID, player2ID, p1Winner FROM Round";
    private final String SELECT_ROUND_BY_ID = "SELECT ID, player1ID, player2ID, p1Winner FROM Round WHERE ID = ?";
    private final String UPDATE_ROUND = "";
    private final String DELETE_ROUND = "DELETE FROM Round WHERE ID = ?";

    private final String SELECT_PLAYER1 = "SELECT p.ID, p.firstName, p.lastName, p.gamertag from Player p "
            + "INNER JOIN Round r ON p.ID = r.player1ID WHERE r.ID = ?";
    private final String SELECT_PLAYER2 = "SELECT p.ID, p.firstName, p.lastName, p.gamertag from Player p "
            + "INNER JOIN Round r ON p.ID = r.player2ID WHERE r.ID = ?";

    @Override
    public Round addRound(Round round) {
        jdbc.update(INSERT_NEW_ROUND, round.getPlayer1().getID(), round.getPlayer2().getID(), round.isP1Winner());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setID(newID);
        return round;
    }

    @Override
    public List<Round> getAllRounds() {
        List<Round> rounds = jdbc.query(SELECT_ALL_ROUNDS, new RoundMapper());
        for (Round round : rounds) {
            setPlayersForRound(round);
        }
        return rounds;
    }

    @Override
    public Round getRoundByID(int ID) {
        Round round = jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), ID);
        setPlayersForRound(round);
        return round;
    }

    @Override
    public void updateRound(Round round) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRound(int ID) {
        jdbc.update(DELETE_ROUND, ID);
    }

    private void setPlayersForRound(Round round) {
        Player player1 = jdbc.queryForObject(SELECT_PLAYER1, new PlayerMapper(), round.getID());
        Player player2 = jdbc.queryForObject(SELECT_PLAYER2, new PlayerMapper(), round.getID());
        round.setPlayer1(player1);
        round.setPlayer2(player2);
    }

    public final static class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int i) throws SQLException {
            Round round = new Round();
            round.setID(rs.getInt("ID"));
            round.setP1Winner(rs.getBoolean("p1Winner"));
            return round;
        }

    }

}
