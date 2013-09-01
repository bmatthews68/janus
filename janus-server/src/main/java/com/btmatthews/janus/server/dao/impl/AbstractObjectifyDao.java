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