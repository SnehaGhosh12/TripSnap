package com.example.tripsnap.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Bus implements Parcelable {

    private String busId;
    private String busName;
    private String source;
    private String destination;
    private String distance;
    private String srcdst;
    private String departTime;
    private String arrivalTime;
    private String fare;
    private String totalSeats;

    public Bus() {
    }

    public Bus(String busId, String busName, String source, String destination, String distance, String srcdst, String departTime, String arrivalTime, String fare, String totalSeats) {
        this.busId = busId;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.srcdst = srcdst;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.fare = fare;
        this.totalSeats = totalSeats;
    }

    protected Bus(Parcel in) {
        busId = in.readString();
        busName = in.readString();
        source = in.readString();
        destination = in.readString();
        distance = in.readString();
        srcdst = in.readString();
        departTime = in.readString();
        arrivalTime = in.readString();
        fare = in.readString();
        totalSeats = in.readString();
    }

    public static final Creator<Bus> CREATOR = new Creator<Bus>() {
        @Override
        public Bus createFromParcel(Parcel in) {
            return new Bus(in);
        }

        @Override
        public Bus[] newArray(int size) {
            return new Bus[size];
        }
    };

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSrcdst() {
        return srcdst;
    }

    public void setSrcdst(String srcdst) {
        this.srcdst = srcdst;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(busId);
        dest.writeString(busName);
        dest.writeString(source);
        dest.writeString(destination);
        dest.writeString(distance);
        dest.writeString(srcdst);
        dest.writeString(departTime);
        dest.writeString(arrivalTime);
        dest.writeString(fare);
        dest.writeString(totalSeats);
    }
}
