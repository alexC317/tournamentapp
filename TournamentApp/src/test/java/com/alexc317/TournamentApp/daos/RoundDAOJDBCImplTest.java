/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Player;
import com.alexc317.TournamentApp.entities.Round;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Alex
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundDAOJDBCImplTest {

    @Autowired
    RoundDAO roundDAO;

    @Autowired
    PlayerDAO playerDAO;

    public RoundDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Round> rounds = roundDAO.getAllRounds();
        for (Round round : rounds) {
            roundDAO.deleteRound(round.getID());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addRound method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testAddAndGetRound() {
        Player player1 = new Player();
        player1.setID(01);
        player1.setFirstName("Alex");
        player1.setLastName("Cepeda");
        player1.setGamertag("DummyThicc");
        playerDAO.addPlayer(player1);

        Player player2 = new Player();
        player2.setID(02);
        player2.setFirstName("Kevin");
        player2.setLastName("Cepeda");
        player2.setGamertag("dweeeb");
        playerDAO.addPlayer(player2);

        Round round = new Round();
        round.setPlayer1(player1);
        round.setPlayer2(player2);
        round.setP1Winner(true);

        roundDAO.addRound(round);
        Round fromDAO = roundDAO.getRoundByID(round.getID());
        assertEquals(fromDAO, round);
    }

    /**
     * Test of getAllRounds method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testGetAllRounds() {
        Player player1 = new Player();
        player1.setID(01);
        player1.setFirstName("Alex");
        player1.setLastName("Cepeda");
        player1.setGamertag("DummyThicc");
        playerDAO.addPlayer(player1);

        Player player2 = new Player();
        player2.setID(02);
        player2.setFirstName("Kevin");
        player2.setLastName("Cepeda");
        player2.setGamertag("dweeeb");
        playerDAO.addPlayer(player2);

        Round round = new Round();
        round.setPlayer1(player1);
        round.setPlayer2(player2);
        round.setP1Winner(true);

        Round round2 = new Round();
        round2.setPlayer1(player1);
        round2.setPlayer2(player2);
        round2.setP1Winner(false);

        Round round3 = new Round();
        round3.setPlayer1(player1);
        round3.setPlayer2(player2);
        round3.setP1Winner(true);

        roundDAO.addRound(round);
        roundDAO.addRound(round2);
        roundDAO.addRound(round3);

        List<Round> rounds = roundDAO.getAllRounds();
        assertEquals(3, rounds.size());
        assertTrue(rounds.contains(round));
        assertTrue(rounds.contains(round2));
        assertTrue(rounds.contains(round3));
    }

    /**
     * Test of getRoundByID method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testGetRoundByID() {
        Player player1 = new Player();
        player1.setID(01);
        player1.setFirstName("Alex");
        player1.setLastName("Cepeda");
        player1.setGamertag("DummyThicc");
        playerDAO.addPlayer(player1);

        Player player2 = new Player();
        player2.setID(02);
        player2.setFirstName("Kevin");
        player2.setLastName("Cepeda");
        player2.setGamertag("dweeeb");
        playerDAO.addPlayer(player2);

        Round round = new Round();
        round.setPlayer1(player1);
        round.setPlayer2(player2);
        round.setP1Winner(true);

        Round round2 = new Round();
        round2.setPlayer1(player1);
        round2.setPlayer2(player2);
        round2.setP1Winner(false);

        Round round3 = new Round();
        round3.setPlayer1(player1);
        round3.setPlayer2(player2);
        round3.setP1Winner(true);

        roundDAO.addRound(round);
        roundDAO.addRound(round2);
        roundDAO.addRound(round3);

        Round fromDAO = roundDAO.getRoundByID(round.getID());
        Round fromDAO2 = roundDAO.getRoundByID(round2.getID());
        Round fromDAO3 = roundDAO.getRoundByID(round3.getID());

        assertEquals(fromDAO, round);
        assertEquals(fromDAO2, round2);
        assertEquals(fromDAO3, round3);
    }

    /**
     * Test of updateRound method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testUpdateRound() {
    }

    /**
     * Test of deleteRound method, of class RoundDAOJDBCImpl.
     */
    @Test
    public void testDeleteRound() {
        Player player1 = new Player();
        player1.setID(01);
        player1.setFirstName("Alex");
        player1.setLastName("Cepeda");
        player1.setGamertag("DummyThicc");
        playerDAO.addPlayer(player1);

        Player player2 = new Player();
        player2.setID(02);
        player2.setFirstName("Kevin");
        player2.setLastName("Cepeda");
        player2.setGamertag("dweeeb");
        playerDAO.addPlayer(player2);

        Round round = new Round();
        round.setPlayer1(player1);
        round.setPlayer2(player2);
        round.setP1Winner(true);

        Round round2 = new Round();
        round2.setPlayer1(player1);
        round2.setPlayer2(player2);
        round2.setP1Winner(false);

        Round round3 = new Round();
        round3.setPlayer1(player1);
        round3.setPlayer2(player2);
        round3.setP1Winner(true);

        roundDAO.addRound(round);
        roundDAO.addRound(round2);
        roundDAO.addRound(round3);

        List<Round> rounds = roundDAO.getAllRounds();
        assertEquals(3, rounds.size());
        assertTrue(rounds.contains(round));
        assertTrue(rounds.contains(round2));
        assertTrue(rounds.contains(round3));

        roundDAO.deleteRound(round.getID());
        roundDAO.deleteRound(round2.getID());

        rounds = roundDAO.getAllRounds();
        assertEquals(1, rounds.size());
        assertFalse(rounds.contains(round));
        assertFalse(rounds.contains(round2));
        assertTrue(rounds.contains(round3));
    }

}
