package com.tsalapova.bicyclerental.entity;


import javax.persistence.Column;

public class Client implements Entity {
    private static final long serialVersionUID = 7708667814123320702L;

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
    private Byte active;

    public Client() {
    }

    public Client(long clientId, String firstName, String middleName, String lastname, String passportNumber,
                  String address, String email, String phone, Byte active) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastname = lastname;
        this.passportNumber = passportNumber;
        this.address = address;
        this.email = email;
        this.phone = phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (clientId != client.clientId) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (middleName != null ? !middleName.equals(client.middleName) : client.middleName != null) return false;
        if (lastname != null ? !lastname.equals(client.lastname) : client.lastname != null) return false;
        if (passportNumber != null ? !passportNumber.equals(client.passportNumber) : client.passportNumber != null)
            return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        return active.equals(client.active);
    }

    @Override
    public int hashCode() {
        int result = (int) (clientId ^ (clientId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + active.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                '}';
    }
}
