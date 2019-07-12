/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Player;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface PlayerDAO {

    public Player addPlayer(Player player);

    public List<Player> getAllPlayers();

    public Player getPlayer(int ID);

    public void editPlayer(Player player);

    public void deletePlayer(int ID);
}
