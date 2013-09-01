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
package com.btmatthews.janus.server.dao.impl;

import com.btmatthews.janus.server.dao.AccountDao;
import com.btmatthews.janus.server.domain.Account;
import com.btmatthews.janus.server.domain.impl.AccountImpl;
import com.googlecode.objectify.Key;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends AbstractObjectifyDao<Account, AccountImpl> implements AccountDao {
    public AccountDaoImpl() {
        super(AccountImpl.class);
    }

    protected Account build(final Key<Account> key, final Account obj) {
        return new AccountImpl(key.getId(), obj.getUserId(), obj.getNickName(), obj.getEmail(), obj.isRegistered(), obj.isEnabled());
    }
}
