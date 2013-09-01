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
