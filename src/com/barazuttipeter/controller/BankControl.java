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

    public void deposit(int id, int amount){
        transfer(0,id,amount);
    }

    public void withdrawal(int id, int amount){
        transfer(id,0, amount);
    }

    public void transfer(int senderId, int recipientId, int amount) {
        BigDecimal balanceChange = new BigDecimal(amount);
        Transfer transfer = new Transfer(amount, senderId, recipientId);
        ClientAccount senderAccount = db.getAccountById(senderId);
        senderAccount.setBalance(
                senderAccount
                        .getBalance()
                        .subtract(balanceChange)
        );
        senderAccount.getTransferHistory()
                .add(transfer);

        ClientAccount recipientAccount = db.getAccountById(recipientId);
        recipientAccount.setBalance(
                recipientAccount
                        .getBalance()
                        .add(balanceChange)
        );
        recipientAccount.getTransferHistory()
                .add(transfer);
    }

}
