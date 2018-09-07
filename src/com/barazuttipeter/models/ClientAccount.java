package com.barazuttipeter.models;

import java.math.BigDecimal;
import java.util.List;

public class ClientAccount {

    static int idCounter = 0;

    private int id;
    private String name;
    private BigDecimal balance;
    private List<Transfer> transferHistory;

    public ClientAccount(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transfer> getTransferHistory() {
        return transferHistory;
    }
}
