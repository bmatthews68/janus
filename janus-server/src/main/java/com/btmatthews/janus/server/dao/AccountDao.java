package com.btmatthews.janus.server.dao;

import com.btmatthews.janus.server.domain.Account;

public interface AccountDao {

    Account create(Account account);

    Account read(String id);

    Account update(Account account);

    void delete(String id);
}
