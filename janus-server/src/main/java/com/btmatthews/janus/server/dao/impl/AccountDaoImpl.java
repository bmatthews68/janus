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
