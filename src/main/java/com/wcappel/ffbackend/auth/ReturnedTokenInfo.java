package com.wcappel.ffbackend.auth;

public class ReturnedTokenInfo {
    private final boolean valid;
    private final String email;

    protected ReturnedTokenInfo(boolean valid, String email) {
        this.valid = valid;
        this.email = email;
    }

    public boolean isValid() {
        return valid;
    }

    public String getEmail() {
        return email;
    }
}
