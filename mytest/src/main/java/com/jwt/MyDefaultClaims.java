package com.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;

public class MyDefaultClaims extends DefaultClaims {

    public static final String ROLE = "role";


    public String getRole() {
        return getString(ROLE);
    }

    public Claims setRole(String role) {
        setValue(ROLE, role);
        return this;
    }
}
