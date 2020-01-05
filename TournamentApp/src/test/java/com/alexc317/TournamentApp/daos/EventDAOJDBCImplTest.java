/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Event;
import java.time.LocalDate;
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
public class EventDAOJDBCImplTest {
    
    @Autowired
    EventDAO eventDAO;
    
    public EventDAOJDBCImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Event> events = eventDAO.getAllEvents();
        for (Event event : events) {
            eventDAO.deleteEvent(event.getID());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addEvent method, of class EventDAOJDBCImpl.
     */
    @Test
    public void testAddEvent() {
        Event event = new Event();
        event.setName("Evolution");
        event.setStartDate(LocalDate.parse("2019-01-01"));
        event.setEndDate(LocalDate.parse("2019-01-04"));
        
        eventDAO.addEvent(event);
        
        Event fromDAO = eventDAO.getEventByID(event.getID());
        assertEquals(fromDAO, event);
    }

    /**
     * Test of getAllEvents method, of class EventDAOJDBCImpl.
     */
    @Test
    public void testGetAllEvents() {
    }

    /**
     * Test of getEventByID method, of class EventDAOJDBCImpl.
     */
    @Test
    public void testGetEventByID() {
    }

    /**
     * Test of updateEvent method, of class EventDAOJDBCImpl.
     */
    @Test
    public void testUpdateEvent() {
    }

    /**
     * Test of deleteEvent method, of class EventDAOJDBCImpl.
     */
    @Test
    public void testDeleteEvent() {
    }
    
}
