package com.barazuttipeter.controller;

import com.barazuttipeter.dao.DatabaseHandler;
import com.barazuttipeter.models.ClientAccount;
import com.barazuttipeter.models.Transfer;

import java.math.BigDecimal;

public class BankControl {

    private DatabaseHandler db;

    public BankControl(DatabaseHandler db) {
        this.db = db;
    }

    public void depositWithdrawal(int id, int amount) {
        BigDecimal balanceChange = new BigDecimal(amount);
        ClientAccount account = db.getAccountById(id);
        account.setBalance(
                account
                        .getBalance()
                        .add(balanceChange)
        );
        account.getTransferHistory()
                .add(new Transfer(amount, 0, id));
    }
}
