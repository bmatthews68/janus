package com.btmatthews.janus.server.service;

import com.btmatthews.janus.server.domain.Account;

import java.util.List;

public interface AccountService {

    int countAccounts();

    List<Account> listAccounts(int offset, int size);

    Account createAccount(Account account);

    Account getAccount(String id);

    Account updateAccount(String id, Account account);

    void deleteAccount(String id);
}
