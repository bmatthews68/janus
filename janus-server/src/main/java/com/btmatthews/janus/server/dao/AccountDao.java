package com.btmatthews.janus.server.dao;

import com.btmatthews.janus.server.domain.Account;

public interface AccountDao {

    Account create(Account account);

    Account read(Long id);

    Account update(Account account);

    void delete(Long id);
}
