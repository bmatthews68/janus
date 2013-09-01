package com.btmatthews.janus.server.domain;

public interface Account {

    Long getId();

    String getUserId();

    String getNickName();

    String getEmail();

    boolean isRegistered();

    boolean isEnabled();
}
