package com.chagiya.middlewares;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthMiddleware {
    private final String REST_API_KEY = Dotenv.load().get("REST_API_KEY");
    private final String PHP_API_KEY = Dotenv.load().get("PHP_API_KEY");

    public String authenticate(String apiKey) {
        if (apiKey.equals(REST_API_KEY)) {
            return "REST";
        } else if (apiKey.equals(PHP_API_KEY)) {
            return "PHP";
        }
        return null;
    }
}
