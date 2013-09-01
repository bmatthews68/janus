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
