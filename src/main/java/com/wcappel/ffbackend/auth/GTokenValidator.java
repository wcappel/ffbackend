package com.wcappel.ffbackend.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Component class GTokenValidator {
    private static final HttpTransport transport = new NetHttpTransport();
    private static final JsonFactory jsonFactory = new GsonFactory();
    private static final String CLIENT_ID = AuthClientIDs.getGClientId();
    private final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
            .setAudience(Collections.singletonList(CLIENT_ID)).build();

    public ReturnedTokenInfo verifyGToken(String idTokenString) {
        try {
            GoogleIdToken idToken = verifier.verify(idTokenString);
            if (idToken != null) {
                GoogleIdToken.Payload payload = idToken.getPayload();
                return new ReturnedTokenInfo(true, payload.getEmail());
            } else {
                System.out.println("Invalid ID token.");
                return new ReturnedTokenInfo(false, null);
            }
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
            System.out.println("Token verification error");
            return new ReturnedTokenInfo(false, null);
        }
    }

}
