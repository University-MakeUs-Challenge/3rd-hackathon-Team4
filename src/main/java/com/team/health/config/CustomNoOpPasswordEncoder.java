package com.team.health.config;

public class CustomNoOpPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword){
        return  rawPassword.toString();
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword){
        return rawPassword.toString().equals(encodedPassword);
    }
}