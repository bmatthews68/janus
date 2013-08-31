package com.btmatthews.janus.server.service.impl;

import com.btmatthews.janus.server.dao.AlarmDao;
import com.btmatthews.janus.server.domain.Account;
import com.btmatthews.janus.server.domain.Alarm;
import com.btmatthews.janus.server.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    public AlarmDao alarmDao;

    public int countAlarms(final Account account) {
        return 0;
    }

    public List<Alarm> listAlarms(final Account account, final int offset, final int size) {
        return new ArrayList<Alarm>();
    }

    public Alarm createAlarm(final Account account, final Alarm alarm) {
        return null;
    }

    public Alarm getAlarm(final Account account, final String id) {
        return null;
    }

    public Alarm updateAlarm(final Account account, final String id, final Alarm alarm) {
        return null;
    }

    public void deleteAlarm(final Account account, final String id) {
    }
}
