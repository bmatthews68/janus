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
