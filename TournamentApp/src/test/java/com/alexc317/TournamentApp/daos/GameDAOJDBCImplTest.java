/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Game;
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
public class GameDAOJDBCImplTest {

    @Autowired
    GameDAO gameDAO;

    public GameDAOJDBCImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        List<Game> games = gameDAO.getAllGames();
        for (Game game : games) {
            gameDAO.deleteGame(game.getID());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddAndGet() {
        Game game = new Game();
        game.setGameName("Street Fighter IV");
        gameDAO.addGame(game);
        
        Game fromDAO = gameDAO.getGame(game.getID());
        assertEquals(fromDAO, game);
    }
    
    @Test
    public void testGetAllGames() {
        Game game1 = new Game();
        game1.setGameName("Street Fighter IV");
        gameDAO.addGame(game1);
        
        Game game2 = new Game();
        game2.setGameName("Tekken 7");
        gameDAO.addGame(game2);
        
        List<Game> games = gameDAO.getAllGames();
        assertEquals(2, games.size());
        assertTrue(games.contains(game1));
        assertTrue(games.contains(game2));
        
    }

}
