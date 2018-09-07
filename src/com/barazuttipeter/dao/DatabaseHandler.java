package com.barazuttipeter.dao;

import com.barazuttipeter.models.ClientAccount;
import com.barazuttipeter.models.Transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    private static List<ClientAccount> ClientAccountList;

    static {
        ClientAccountList = new ArrayList() {
            {
                add(new ClientAccount("Cash Deposit"));
                add(new ClientAccount("Client Katalin"));
                add(new ClientAccount("Client Károly"));
                add(new ClientAccount("Some Random Client"));
            }
        };
        ClientAccountList.get(1).getTransferHistory().add(new Transfer(1000, 0, 1));
        ClientAccountList.get(2).getTransferHistory().add(new Transfer(5000, 0, 2));
        ClientAccountList.get(3).getTransferHistory().add(new Transfer(2300, 0, 3));
    }

    public ClientAccount getAccountById(int id) {
        return ClientAccountList.get(id);
    }
}
