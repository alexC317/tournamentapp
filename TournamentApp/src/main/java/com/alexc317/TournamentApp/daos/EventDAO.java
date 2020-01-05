/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Event;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface EventDAO {
    
    public Event addEvent(Event event);
    
    public List<Event> getAllEvents();
    
    public Event getEventByID(int ID);
    
    public void updateEvent(Event event);
    
    public void deleteEvent(int ID);
    
}
