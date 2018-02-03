package com.tsalapova.bicyclerental.entity;


import javax.persistence.Column;
import java.util.Objects;

public class Client {
  @Column(name = "client_id")
  private long clientId;
  @Column(name = "first_name")
  private String firstName;
  @Column(name="middle_name")
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

  public Client(){}

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
    return clientId == client.clientId &&
            Objects.equals(firstName, client.firstName) &&
            Objects.equals(middleName, client.middleName) &&
            Objects.equals(lastname, client.lastname) &&
            Objects.equals(passportNumber, client.passportNumber) &&
            Objects.equals(address, client.address) &&
            Objects.equals(email, client.email) &&
            Objects.equals(phone, client.phone) &&
            Objects.equals(active, client.active);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, firstName, middleName, lastname, passportNumber, address, email, phone, active);
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
            ", active='" + active + '\'' +
            '}';
  }
}
