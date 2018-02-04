package com.tsalapova.bicyclerental.entity;

import javax.persistence.Column;
import java.util.Objects;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class Bicycle implements Entity {
    @Column(name = "bycicle_id")
    private long bicycleId;
    @Column(name = "location_id")
    private long locationId;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String material;
    @Column
    private String type;
    @Column(name = "price_ph")
    private double pricePh;

    public Bicycle() {
    }

    public Bicycle(long bicycleId, long locationId, String brand, String model, String material, String type, double pricePh) {
        this.bicycleId = bicycleId;
        this.locationId = locationId;
        this.brand = brand;
        this.model = model;
        this.material = material;
        this.type = type;
        this.pricePh = pricePh;
    }

    public long getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(long bicycleId) {
        this.bicycleId = bicycleId;
    }


    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public double getPricePh() {
        return pricePh;
    }

    public void setPricePh(double pricePh) {
        this.pricePh = pricePh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicycle)) return false;
        Bicycle bicycle = (Bicycle) o;
        return bicycleId == bicycle.bicycleId &&
                locationId == bicycle.locationId &&
                Double.compare(bicycle.pricePh, pricePh) == 0 &&
                Objects.equals(brand, bicycle.brand) &&
                Objects.equals(model, bicycle.model) &&
                Objects.equals(material, bicycle.material) &&
                Objects.equals(type, bicycle.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bicycleId, locationId, brand, model, material, type, pricePh);
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "bicycleId=" + bicycleId +
                ", locationId=" + locationId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", material='" + material + '\'' +
                ", type='" + type + '\'' +
                ", pricePh=" + pricePh +
                '}';
    }
}
