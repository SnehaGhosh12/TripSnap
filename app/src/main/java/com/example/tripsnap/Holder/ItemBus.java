package com.example.tripsnap.Holder;

public class ItemBus {

    String bus_id,source,destination, time,fare;

    public ItemBus(String bus_id, String source, String destination, String time, String fare) {
        this.bus_id = bus_id;
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.fare = fare;
    }

    public String getBus_id() {
        return bus_id;
    }

    public void setBus_id(String bus_id) {
        this.bus_id = bus_id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }
}
