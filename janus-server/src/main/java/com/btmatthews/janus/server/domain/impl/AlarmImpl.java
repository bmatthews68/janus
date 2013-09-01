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