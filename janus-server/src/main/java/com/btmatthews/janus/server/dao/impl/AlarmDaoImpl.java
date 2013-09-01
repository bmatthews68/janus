package com.btmatthews.janus.server.dao.impl;

import com.btmatthews.janus.server.dao.AlarmDao;
import com.btmatthews.janus.server.domain.Alarm;
import com.btmatthews.janus.server.domain.impl.AlarmImpl;
import com.googlecode.objectify.Key;
import org.springframework.stereotype.Repository;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Repository
public class AlarmDaoImpl extends AbstractObjectifyDao<Alarm, AlarmImpl> implements AlarmDao {

    public AlarmDaoImpl() {
        super(AlarmImpl.class);
    }

    protected Alarm build(final Key<Alarm> key, final Alarm obj) {
        return new AlarmImpl(key.getId(), obj.getAccountId(), obj.getHour(), obj.getMinute(), obj.getDays(), obj.isEnabled());
    }
}
