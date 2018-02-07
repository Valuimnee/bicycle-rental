package com.tsalapova.bicyclerental.entity;


import javax.persistence.Column;
import java.util.Date;
import java.util.Objects;

/**
 * @author TsalapovaMD
 * @version 1.0, 1/3/2018
 */
public class Card implements Entity {
    @Column(name = "card_id")
    private long cardId;
    @Column(name = "client_id")
    private long clientId;
    @Column
    private String type;
    @Column
    private String number;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Column(name = "holder_name")
    private String holderName;
    @Column(name = "CVV2")
    private String cvv2;

    public Card() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return cardId == card.cardId &&
                clientId == card.clientId &&
                Objects.equals(type, card.type) &&
                Objects.equals(number, card.number) &&
                Objects.equals(expirationDate, card.expirationDate) &&
                Objects.equals(holderName, card.holderName) &&
                Objects.equals(cvv2, card.cvv2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, clientId, type, number, expirationDate, holderName, cvv2);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", clientId=" + clientId +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", expirationDate=" + expirationDate +
                ", holderName='" + holderName + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                '}';
    }
}
