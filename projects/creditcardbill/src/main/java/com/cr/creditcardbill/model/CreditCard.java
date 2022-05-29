package com.cr.creditcardbill.model;

public class CreditCard {
    private int number_credit_card;
    private Client client;

    public CreditCard() {
    }

    public int getNumber_credit_card() {
        return number_credit_card;
    }

    public void setNumber_credit_card(int number_credit_card) {
        this.number_credit_card = number_credit_card;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
