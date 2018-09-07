package com.barazuttipeter.controller;

import com.barazuttipeter.dao.DatabaseHandler;
import com.barazuttipeter.models.ClientAccount;
import com.barazuttipeter.models.Transfer;
import com.barazuttipeter.util.NotEnoughMoneyExc;
import com.barazuttipeter.util.TransactionType;

import java.math.BigDecimal;

public class BankControl {

    private DatabaseHandler db;

    public BankControl(DatabaseHandler db) {
        this.db = db;
    }

    public void deposit(int id, int amount) {
        transfer(0, id, amount);
    }

    public void withdrawal(int id, int amount) {
        transfer(id, 0, amount);
    }

    public void transfer(int senderId, int recipientId, int amount) {
        try {
            BigDecimal balanceChange = new BigDecimal(amount);
            Transfer transfer = new Transfer(amount, senderId, recipientId);
            ClientAccount senderAccount = db.getAccountById(senderId);
            if (balanceChange.compareTo(senderAccount.getBalance()) == 1 && senderId != 0) {
                throw new NotEnoughMoneyExc("Sender is poor");
            }
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
        } catch (NotEnoughMoneyExc e) {
            System.out.println("Transaction did not complete!");
            e.printStackTrace();
        }
    }

    public void printHistory(int id) {
        ClientAccount account = db.getAccountById(id);
        System.out.println("Client's balance: " + account.getBalance());
        System.out.println("Transfer history:");
        for (Transfer tf : account.getTransferHistory()) {
            System.out.println(tf);
        }
    }

    public void showDepositsOrWithdrawals(int id, TransactionType transactionType) {
        ClientAccount account = db.getAccountById(id);
        for (Transfer tf : account.getTransferHistory()) {
            if (tf.getSenderId() == 0
                    && transactionType.equals(TransactionType.DEPOSIT)) {
                System.out.println(tf);
            } else if (tf.getRecipientId() == 0
                    && transactionType.equals(TransactionType.WITHDRAWAL)) {
                System.out.println(tf);
            }
        }
    }

}
