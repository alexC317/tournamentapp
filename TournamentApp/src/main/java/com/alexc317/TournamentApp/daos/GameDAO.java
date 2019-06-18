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

    public Game create(Game game);

    public List<Game> readAll();

    public Game readByID(int ID);

    public void update(Game game);

    public void delete(int ID);
}
