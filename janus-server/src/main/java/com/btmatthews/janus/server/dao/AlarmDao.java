package com.btmatthews.janus.server.dao;

import com.btmatthews.janus.server.domain.Alarm;

public interface AlarmDao {

    Alarm create(Alarm alarm);

    Alarm read(String id);

    Alarm update(Alarm alarm);

    void delete(String id);
}
