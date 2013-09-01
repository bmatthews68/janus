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
package com.btmatthews.janus.server.security;

import com.btmatthews.janus.server.domain.Account;
import com.btmatthews.janus.server.domain.impl.AccountImpl;
import com.btmatthews.janus.server.service.AccountService;
import com.google.appengine.api.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component("gaeAuthenticationProvider")
public class GAEAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AccountService accountService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final User user = (User) authentication.getPrincipal();

        Account account = accountService.getAccount(user.getUserId());
        if (account == null) {
            account = new AccountImpl(user.getUserId(), user.getNickname(), user.getEmail());
        }

        if (!account.isEnabled()) {
            throw new DisabledException("Account is disabled");
        }

        return new GAEUserAuthentication(account, authentication.getDetails());
    }

    public final boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

