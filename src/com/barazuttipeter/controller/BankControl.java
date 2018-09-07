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
