package com.tsalapova.bicyclerental.entity;

import javax.persistence.Column;

/**
 * @author TsalapovaMD
 * @version 1.0, 2/19/2018
 */
public class Account implements Entity {
    private static final long serialVersionUID = 5772525459724787361L;

    @Column(name = "client_id")
    private long clientId;
    @Column
    private double balance;
    @Column
    private double credit;

    public Account() {
    }

    public Account(long clientId, double balance, double credit) {
        this.clientId = clientId;
        this.balance = balance;
        this.credit = credit;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return clientId == account.clientId && Double.compare(account.balance, balance) == 0 &&
                Double.compare(account.credit, credit) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (clientId ^ (clientId >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(credit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "clientId=" + clientId +
                ", balance=" + balance +
                ", credit=" + credit +
                '}';
    }
}
