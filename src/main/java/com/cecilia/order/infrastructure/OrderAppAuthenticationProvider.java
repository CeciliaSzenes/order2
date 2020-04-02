package com.cecilia.order.infrastructure;

import com.cecilia.order.infrastructure.external.ExternalAuthentication;
import com.cecilia.order.infrastructure.external.FakeAuthenticationService;
import com.cecilia.order.infrastructure.feature.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

    @Component
    public class OrderAppAuthenticationProvider implements AuthenticationProvider { //with abstract it is happy

        FakeAuthenticationService authService;

        @Autowired
        public OrderAppAuthenticationProvider(FakeAuthenticationService authService) {
            this.authService = authService;
        }


        public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) {
            String username = authentication.getName(); //with name, it works
            String password = authentication.getCredentials().toString();//it is supposed to be an official method

            ExternalAuthentication user = authService.getUser(username, password);
            if (user==null){
                throw new BadCredentialsException("Username and password not found.");
            } else {
                return new UsernamePasswordAuthenticationToken(username, password, rolesToGrantedAuthorities(Feature.getFeaturesForRoles(user.getRoles())));
            }
        }

            private Collection<? extends GrantedAuthority> rolesToGrantedAuthorities (List < Feature > features) {
                return features.stream()
                        .map(Enum::name)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
            }


            @Override
            public boolean supports (Class < ? > authentication){
                return authentication.equals(UsernamePasswordAuthenticationToken.class);

            }
        }