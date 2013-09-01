package com.btmatthews.janus.server.service.impl;

import com.btmatthews.janus.server.dao.AccountDao;
import com.btmatthews.janus.server.domain.Account;
import com.btmatthews.janus.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public int countAccounts() {
        return 0;
    }

    public List<Account> listAccounts(final int offset, final int size) {
        return new ArrayList<Account>();
    }

    public Account createAccount(final Account account) {
        return accountDao.create(account);
    }

    public Account getAccount(final String id) {
        return accountDao.read(id);
    }

    public Account updateAccount(final String id, final Account account) {
        return accountDao.update(account);
    }

    public void deleteAccount(final String id) {
        accountDao.delete(id);
    }
}
