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
import com.btmatthews.janus.server.domain.Alarm;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class AlarmImpl implements Alarm {

    @Id
    private Long id;

    @Index
    private Key<Account> account;

    private int hour;

    private int minute;

    private boolean[] days = new boolean[7];

    private boolean enabled;

    public AlarmImpl() {
    }

    public AlarmImpl(final Long id, final Long accountId, final int hour, final int minute, final boolean[] days, final boolean enabled) {
        this.account = Key.create(Account.class, accountId);
        this.hour = hour;
        this.minute = minute;
        this.days = days;
        this.enabled = enabled;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getAccountId() {
        return account.getId();
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public int getMinute() {
        return minute;
    }

    @Override
    public boolean[] getDays() {
        return days;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}