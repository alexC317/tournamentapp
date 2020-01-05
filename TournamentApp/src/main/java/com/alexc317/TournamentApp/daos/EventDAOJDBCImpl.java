/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.daos;

import com.alexc317.TournamentApp.entities.Event;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOJDBCImpl implements EventDAO {
    
    @Autowired
    private JdbcTemplate jdbc;
    
    private final String INSERT_NEW_EVENT = "INSERT INTO Event(name, startDate, endDate) VALUES (?, ?, ?)";
    private final String SELECT_ALL_EVENTS = "SELECT ID, name, startDate, endDate FROM Event";
    private final String SELECT_EVENT_BY_ID = "SELECT ID, name, startDate, endDate FROM Event WHERE ID = ?";
    private final String UPDATE_EVENT = "";
    private final String DELETE_EVENT = "DELETE FROM Event WHERE ID = ?";
    

    @Override
    public Event addEvent(Event event) {
        jdbc.update(INSERT_NEW_EVENT, event.getName(), event.getStartDate(), event.getEndDate());
        int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        event.setID(newID);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        return jdbc.query(SELECT_ALL_EVENTS, new EventMapper());
    }

    @Override
    public Event getEventByID(int ID) {
        return jdbc.queryForObject(SELECT_EVENT_BY_ID, new EventMapper(), ID);
    }

    @Override
    public void updateEvent(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEvent(int ID) {
        jdbc.update(DELETE_EVENT, ID);
    }
    
    public static final class EventMapper implements RowMapper<Event>{

        @Override
        public Event mapRow(ResultSet rs, int i) throws SQLException {
            Event event = new Event();
            event.setID(rs.getInt("ID"));
            event.setName(rs.getString("name"));
            event.setStartDate(rs.getDate("startDate").toLocalDate());
            event.setEndDate(rs.getDate("endDate").toLocalDate());
            
            return event;
        }
        
    }
    
}
