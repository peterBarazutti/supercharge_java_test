package com.barazuttipeter;

import com.barazuttipeter.controller.BankControl;
import com.barazuttipeter.dao.DatabaseHandler;
import com.barazuttipeter.models.Transfer;

public class Main {

    public static void main(String[] args) {
        DatabaseHandler dbh = new DatabaseHandler();
        BankControl bc = new BankControl(dbh);
        bc.deposit(1,2000);
        bc.deposit(1, 3000);
        bc.printHistory(1);
        bc.withdrawal(1,6000);
        }
    }

