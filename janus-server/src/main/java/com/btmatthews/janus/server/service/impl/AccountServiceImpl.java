/*
 * Janus Alarm Manager
 * Copyright (C) 2013 Brian Matthews
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see {http://www.gnu.org/licenses/}.
 */
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
