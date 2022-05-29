package com.cr.creditcardbill.model;

import java.util.ArrayList;
import java.util.List;

public class CreditCardBill {
    private Client client;
    private CreditCard creditCard;
    private List<Transaction> transactions = new ArrayList<>();

    public CreditCardBill() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
