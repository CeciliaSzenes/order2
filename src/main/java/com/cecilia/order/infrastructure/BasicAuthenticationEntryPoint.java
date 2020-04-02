package com.cecilia.order.infrastructure;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BasicAuthenticationEntryPoint extends AuthenticationEntryPoint, InitializingBean {
    String NAME_OF_REALM = "BookstoreRealm";

    void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx);
}
