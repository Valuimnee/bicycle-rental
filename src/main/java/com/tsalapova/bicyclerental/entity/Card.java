package com.tsalapova.bicyclerental.entity;


import java.util.Date;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class Card implements Entity {

  private long cardId;
  private long clientId;
  private String type;
  private String number;
  private Date expirationDate;
  private String holderName;
  private String cvv2;

  public Card(long cardId, long clientId, String type, String number, Date expirationDate, String holderName, String cvv2) {
    this.cardId = cardId;
    this.clientId = clientId;
    this.type = type;
    this.number = number;
    this.expirationDate = expirationDate;
    this.holderName = holderName;
    this.cvv2 = cvv2;
  }

  public long getCardId() {
    return cardId;
  }

  public void setCardId(long cardId) {
    this.cardId = cardId;
  }


  public long getClientId() {
    return clientId;
  }

  public void setClientId(long clientId) {
    this.clientId = clientId;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDat(Date expirationDate) {
    this.expirationDate = expirationDate;
  }


  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }


  public String getCvv2() {
    return cvv2;
  }

  public void setCvv2(String cvv2) {
    this.cvv2 = cvv2;
  }

}
