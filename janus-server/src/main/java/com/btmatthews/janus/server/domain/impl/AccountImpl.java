package com.btmatthews.janus.server.domain.impl;

import com.btmatthews.janus.server.domain.Account;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class AccountImpl implements Account {

    @Id
    private Long id;

    private String userId;

    private String nickName;

    private String email;

    private boolean registered;

    private boolean enabled;

    public AccountImpl(final String userId, final String nickName, final String email) {
        this(null, userId, nickName, email, false, false);
    }

    public AccountImpl(final Long id, final String userId, final String nickName, final String email, final boolean registered, final boolean enabled) {
        this.id = id;
        this.userId = userId;
        this.nickName = nickName;
        this.email = email;
        this.registered = registered;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isRegistered() {
        return registered;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
