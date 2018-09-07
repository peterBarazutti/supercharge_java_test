package com.barazuttipeter.models;

import java.math.BigDecimal;
import java.util.Date;

public class Transfer {

    static int idCounter = 0;

    private int id;
    private int amount;
    private int senderId;
    private int recipientId;
    private Date transferDate;

    public Transfer(int amount, int senderId, int recipientId) {
        this.amount = amount;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transferDate = new Date();
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public Date getTransferDate() {
        return transferDate;
    }
}
