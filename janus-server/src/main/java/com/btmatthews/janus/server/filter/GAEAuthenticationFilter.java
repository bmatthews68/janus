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
package com.btmatthews.janus.server.filter;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("gaeAuthenticationFilter")
public class GAEAuthenticationFilter extends GenericFilterBean {

    private final AuthenticationDetailsSource ads = new WebAuthenticationDetailsSource();

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthenticationFailureHandler failureHandler;

    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            // User isn't authenticated. Check if there is a Google Accounts user
            final User googleUser = UserServiceFactory.getUserService().getCurrentUser();

            if (googleUser != null) {
                // User has returned after authenticating through GAE. Need to authenticate to Spring Security.
                final PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(googleUser, null);
                token.setDetails(ads.buildDetails(request));

                try {
                    authentication = authenticationManager.authenticate(token);
                    // Setup the security context
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    // Send new users to the registration page.
                   /* if (authentication.getAuthorities().contains(AppRole.NEW_USER)) {
                        ((HttpServletResponse) response).sendRedirect(REGISTRATION_URL);
                        return;
                    }*/
                } catch (final AuthenticationException e) {
                    // Authentication information was rejected by the authentication manager
                    failureHandler.onAuthenticationFailure((HttpServletRequest) request, (HttpServletResponse) response, e);
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }
}
