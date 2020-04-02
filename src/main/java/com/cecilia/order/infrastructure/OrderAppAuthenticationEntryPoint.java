package com.cecilia.order.infrastructure;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

    @Component
    public class OrderAppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint implements com.cecilia.order.infrastructure.BasicAuthenticationEntryPoint {

        public OrderAppAuthenticationEntryPoint() {
            setRealmName(NAME_OF_REALM);
        }

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) {
            response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

