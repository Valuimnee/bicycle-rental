package com.tsalapova.bicyclerental.entity;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class Bicycle implements Entity {

    private long bicycleId;
    private long locationId;
    private String brand;
    private String model;
    private String material;
    private String type;
    private double pricePh;

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

}
