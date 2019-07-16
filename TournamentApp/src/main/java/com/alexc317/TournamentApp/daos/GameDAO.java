/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Game;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface GameDAO {

    public Game addGame(Game game);

    public List<Game> getAllGames();

    public Game getGame(int ID);

    public void updateGame(Game game);

    public void deleteGame(int ID);
}
