package com.example.tripsnap.Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {

    private Integer reservationID;
    private String status;
    private LocalDate date;
    private LocalTime time;
    private Long userId;
    private String busId;
    private String source;
    private String destination;
    private LocalDate journeyDate;
    private Integer bookedSeat;
    private Integer fare;

    public Reservation() {
    }

    public Reservation(Integer reservationID, String status, LocalDate date, LocalTime time, Long userId, String busId, String source, String destination, LocalDate journeyDate, Integer bookedSeat, Integer fare) {
        this.reservationID = reservationID;
        this.status = status;
        this.date = date;
        this.time = time;
        this.userId = userId;
        this.busId = busId;
        this.source = source;
        this.destination = destination;
        this.journeyDate = journeyDate;
        this.bookedSeat = bookedSeat;
        this.fare = fare;
    }

    public Reservation(String source, String destination, LocalDate journeyDate, Integer bookedSeat, Integer fare,Integer reservationID, String status, LocalDate date, LocalTime time) {
        this.source = source;
        this.destination = destination;
        this.journeyDate = journeyDate;
        this.bookedSeat = bookedSeat;
        this.fare = fare;
        this.reservationID = reservationID;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Integer getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(Integer bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }
}
