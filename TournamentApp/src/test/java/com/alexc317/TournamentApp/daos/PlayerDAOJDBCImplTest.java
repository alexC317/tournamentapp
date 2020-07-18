/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Player;
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
public class PlayerDAOJDBCImplTest {

    @Autowired
    PlayerDAO playerDAO;

    public PlayerDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Player> players = playerDAO.getAllPlayers();
        for (Player player : players) {
            playerDAO.deletePlayer(player.getPlayerID());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addPlayer method, of class PlayerDAOJDBCImpl.
     */
    @Test
    public void testAddAndGetPlayer() {
        Player player = new Player();
        player.setPlayerFirstName("Alex");
        player.setPlayerLastName("Cepeda");
        player.setPlayerDisplayName("gris317");

        playerDAO.addPlayer(player);

        Player fromDAO = playerDAO.getPlayer(player.getPlayerID());
        assertEquals(fromDAO, player);
    }

    /**
     * Test of addPlayer method, of class PlayerDAOJDBCImpl.
     */
    @Test
    public void testAddAndGetPlayerNullGamertag() {
        Player player = new Player();
        player.setPlayerFirstName("Alex");
        player.setPlayerLastName("Cepeda");
        playerDAO.addPlayer(player);

        Player fromDAO = playerDAO.getPlayer(player.getPlayerID());
        assertEquals(fromDAO, player);
    }

    /**
     * Test of getAllPlayers method, of class PlayerDAOJDBCImpl.
     */
    @Test
    public void testGetAllPlayers() {
        Player player1 = new Player();
        player1.setPlayerFirstName("Alex");
        player1.setPlayerLastName("Cepeda");
        player1.setPlayerDisplayName("gris317");
        playerDAO.addPlayer(player1);

        Player player2 = new Player();
        player2.setPlayerFirstName("Kevin");
        player2.setPlayerLastName("Cepeda");
        player2.setPlayerDisplayName("dweeb");
        playerDAO.addPlayer(player2);

        List<Player> players = playerDAO.getAllPlayers();
        assertEquals(2, players.size());
        assertTrue(players.contains(player1));
        assertTrue(players.contains(player2));
    }

    /**
     * Test of editPlayer method, of class PlayerDAOJDBCImpl.
     */
    @Test
    public void testEditPlayer() {
        Player player1 = new Player();
        player1.setPlayerFirstName("Alex");
        player1.setPlayerLastName("Cepeda");
        player1.setPlayerDisplayName("gris317");
        playerDAO.addPlayer(player1);

        Player fromDAO = playerDAO.getPlayer(player1.getPlayerID());
        assertEquals(fromDAO, player1);

        player1.setPlayerDisplayName("thepretender317");
        playerDAO.editPlayer(player1);
        assertNotEquals(fromDAO, player1);

        fromDAO = playerDAO.getPlayer(player1.getPlayerID());
        assertEquals(fromDAO, player1);

    }

    /**
     * Test of editPlayer method, of class PlayerDAOJDBCImpl.
     */
    @Test
    public void testEditPlayerNullGamerTag() {
        Player player1 = new Player();
        player1.setPlayerFirstName("Alex");
        player1.setPlayerLastName("Cepeda");
        player1.setPlayerDisplayName("gris317");
        playerDAO.addPlayer(player1);

        Player fromDAO = playerDAO.getPlayer(player1.getPlayerID());
        assertEquals(fromDAO, player1);

        player1.setPlayerDisplayName(null);
        playerDAO.editPlayer(player1);
        assertNotEquals(fromDAO, player1);

        fromDAO = playerDAO.getPlayer(player1.getPlayerID());
        assertEquals(fromDAO, player1);

    }

    /**
     * Test of deletePlayer method, of class PlayerDAOJDBCImpl.
     */
    @Test
    public void testDeletePlayer() {
        Player player1 = new Player();
        player1.setPlayerFirstName("Alex");
        player1.setPlayerLastName("Cepeda");
        player1.setPlayerDisplayName("gris317");
        playerDAO.addPlayer(player1);

        Player player2 = new Player();
        player2.setPlayerFirstName("Kevin");
        player2.setPlayerLastName("Cepeda");
        player2.setPlayerDisplayName("dweeb");
        playerDAO.addPlayer(player2);

        List<Player> players = playerDAO.getAllPlayers();
        assertEquals(2, players.size());
        assertTrue(players.contains(player1));
        assertTrue(players.contains(player2));

        playerDAO.deletePlayer(player1.getPlayerID());
        players = playerDAO.getAllPlayers();
        assertEquals(1, players.size());
        assertFalse(players.contains(player1));
        assertTrue(players.contains(player2));

    }

}
