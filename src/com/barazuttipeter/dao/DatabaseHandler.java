package com.barazuttipeter.dao;

import com.barazuttipeter.models.ClientAccount;
import com.barazuttipeter.models.Transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    public static List<ClientAccount> ClientAccountList;

    static {
        ClientAccountList = new ArrayList() {
            {
                add(new ClientAccount("Cash Deposit"));
                add(new ClientAccount("Client Katalin"));
                add(new ClientAccount("Client Károly"));
                add(new ClientAccount("Some Random Client"));
            }
        };
    }

    public ClientAccount getAccountById(int id) {
        return ClientAccountList.get(id);
    }
}
