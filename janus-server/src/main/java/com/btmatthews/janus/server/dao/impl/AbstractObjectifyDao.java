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
package com.btmatthews.janus.server.dao.impl;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

import static com.googlecode.objectify.ObjectifyService.ofy;

public abstract class AbstractObjectifyDao<T, U extends T> {

    private Class<U> type;

    public AbstractObjectifyDao(final Class<U> type) {
        this.type = type;
        ObjectifyService.register(type);
    }

    public T create(final T obj) {
        final Key<T> key = ofy().save().entity(obj).now();
        return build(key, obj);
    }

    public T read(final String id) {
        return ofy().load().type(type).id(id).now();
    }

    public T update(final T obj) {
        ofy().save().entity(obj).now();
        return obj;
    }

    public void delete(final String id) {
        ofy().delete().type(type).id(id).now();
    }

    protected abstract T build(Key<T> key, T obj);
}