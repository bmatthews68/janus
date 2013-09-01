package com.btmatthews.janus.server.security;

import com.btmatthews.janus.server.domain.Account;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

public class GAEUserAuthentication implements Authentication {

    private Account principal;
    private Object details;
    private boolean authenticated;

    public GAEUserAuthentication(final Account principal, final Object details) {
        this.principal = principal;
        this.details = details;
        this.authenticated = true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public Object getCredentials() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(final boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return principal.getUserId();
    }
}
