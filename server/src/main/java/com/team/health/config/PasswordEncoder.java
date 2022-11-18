package com.team.health.config;

public interface PasswordEncoder {
    public String encode(CharSequence rawPassword);

    public boolean matches(CharSequence rawPassword, String encodedPassword);

}
