package com.tsalapova.bicyclerental.entity;


public class Rental {

  private long rentalId;
  private long clientId;
  private long bicycleId;
  private java.sql.Timestamp startTime;
  private long hours;
  private double total;
  private String status;


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


  public long getHours() {
    return hours;
  }

  public void setHours(long hours) {
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

}
