package com.tsalapova.bicyclerental.entity;


import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.Objects;

public class Rental implements Entity {
    private static final long serialVersionUID = 6096428443128149736L;

    @Column(name = "rental_id")
    private long rentalId;
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "bicycle_id")
    private long bicycleId;
    @Column(name = "start_time")
    private java.sql.Timestamp startTime;
    @Column
    private int hours;
    @Column
    private double total;
    @Column
    private String status;

    public Rental() {
    }

    public Rental(long rentalId, long clientId, long bicycleId, Timestamp startTime, int hours, double total, String status) {
        this.rentalId = rentalId;
        this.clientId = clientId;
        this.bicycleId = bicycleId;
        this.startTime = startTime;
        this.hours = hours;
        this.total = total;
        this.status = status;
    }

    public long getRentalId() {
        return rentalId;
    }

    public void setRentalId(long rentalId) {
        this.rentalId = rentalId;
    }


    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }


    public long getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(long bicycleId) {
        this.bicycleId = bicycleId;
    }


    public java.sql.Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(java.sql.Timestamp startTime) {
        this.startTime = startTime;
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rental)) return false;
        Rental rental = (Rental) o;
        return rentalId == rental.rentalId &&
                clientId == rental.clientId &&
                bicycleId == rental.bicycleId &&
                hours == rental.hours &&
                Double.compare(rental.total, total) == 0 &&
                Objects.equals(startTime, rental.startTime) &&
                Objects.equals(status, rental.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, clientId, bicycleId, startTime, hours, total, status);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", clientId=" + clientId +
                ", bicycleId=" + bicycleId +
                ", startTime=" + startTime +
                ", hours=" + hours +
                ", total=" + total +
                ", status='" + status + '\'' +
                '}';
    }
}
