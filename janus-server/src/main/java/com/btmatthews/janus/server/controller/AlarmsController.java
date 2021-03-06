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
package com.btmatthews.janus.server.controller;

import com.btmatthews.janus.server.domain.Alarm;
import com.btmatthews.janus.server.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlarmsController {

    @Autowired
    private AlarmService alarmService;

    @RequestMapping(value = "/alarms", method = RequestMethod.GET)
    @ResponseBody
    public List<Alarm> listAlarms(@RequestHeader("offset") final int offset, @RequestHeader("size") final int size) {
        return alarmService.listAlarms(null, offset, size);
    }

    @RequestMapping(value = "/alarms", method = RequestMethod.POST)
    @ResponseBody
    public Alarm createAlarm(final Alarm alarm) {
        return alarmService.createAlarm(null, alarm);
    }

    @RequestMapping(value = "/alarms/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Alarm getAlarm(@PathVariable("id") final String id) {
        return alarmService.getAlarm(null, id);
    }

    @RequestMapping(value = "/alarms/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Alarm updateAlarm(@PathVariable("id") final String id, @RequestBody final Alarm alarm) {
        return alarmService.updateAlarm(null, id, alarm);
    }

    @RequestMapping(value = "/alarms/{id}", method = RequestMethod.DELETE)
    public void deleteAlarm(@PathVariable("id") final String id) {
        alarmService.deleteAlarm(null, id);
    }
}
