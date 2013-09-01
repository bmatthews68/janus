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

