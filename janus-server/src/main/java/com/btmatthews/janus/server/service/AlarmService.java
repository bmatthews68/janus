package com.btmatthews.janus.server.service;

import com.btmatthews.janus.server.domain.Account;
import com.btmatthews.janus.server.domain.Alarm;

import java.util.List;

public interface AlarmService {

    int countAlarms(Account account);

    List<Alarm> listAlarms(Account account, int offset, int size);

    Alarm createAlarm(Account account, Alarm alarm);

    Alarm getAlarm(Account account, String id);

    Alarm updateAlarm(Account account, String id, Alarm alarm);

    void deleteAlarm(Account account, String id);
}
