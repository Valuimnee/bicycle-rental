package com.tsalapova.bicyclerental.entity;


import javax.persistence.Column;
import java.util.Objects;

public class Location implements Entity {
    @Column(name = "location_id")
    private long locationId;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phone;

    public Location() {
    }

    public Location(long locationId, String name, String address, String phone) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return locationId == location.locationId &&
                Objects.equals(name, location.name) &&
                Objects.equals(address, location.address) &&
                Objects.equals(phone, location.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, name, address, phone);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
