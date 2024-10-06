package org.example.urlshortener.model;

public class Url {
    private String id;
    private String originalUrl;

    public Url(String id, String originalUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
    }

    public String getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
