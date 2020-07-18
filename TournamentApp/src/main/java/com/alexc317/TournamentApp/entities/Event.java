/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexc317.TournamentApp.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Alex
 */
public class Event {

    private int eventID;
    private String eventName;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(LocalDate eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public LocalDate getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(LocalDate eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.eventID;
        hash = 29 * hash + Objects.hashCode(this.eventName);
        hash = 29 * hash + Objects.hashCode(this.eventStartDate);
        hash = 29 * hash + Objects.hashCode(this.eventEndDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.eventID != other.eventID) {
            return false;
        }
        if (!Objects.equals(this.eventName, other.eventName)) {
            return false;
        }
        if (!Objects.equals(this.eventStartDate, other.eventStartDate)) {
            return false;
        }
        if (!Objects.equals(this.eventEndDate, other.eventEndDate)) {
            return false;
        }
        return true;
    }

}
