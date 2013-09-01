package com.btmatthews.janus.server.domain;

public interface Alarm {

    Long getId();

    Long getAccountId();

    int getHour();

    int getMinute();

    boolean[] getDays();

    boolean isEnabled();
}
