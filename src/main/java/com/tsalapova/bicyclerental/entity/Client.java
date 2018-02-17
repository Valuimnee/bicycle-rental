package com.tsalapova.bicyclerental.entity;


import javax.persistence.Column;
import java.util.Objects;

public class Client implements Entity {
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column
    private String lastname;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private double balance;
    @Column
    private double credit;
    @Column
    private Byte active;

    public Client() {
    }

    public Client(long clientId, String firstName, String middleName, String lastname, String passportNumber,
                  String address, String email, String phone, double balance, double credit, Byte active) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastname = lastname;
        this.passportNumber = passportNumber;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.credit = credit;
        this.active = active;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

}
