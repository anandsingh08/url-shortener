package org.example.urlshortener.service;

import org.example.urlshortener.model.Url;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UrlShortenerService {
    private final Map<String, Url> urlStore = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger();

    public String shortenUrl(String originalUrl) {
        int id = counter.incrementAndGet();
        String shortUrl = Integer.toHexString(id);
        Url url = new Url(shortUrl, originalUrl);
        urlStore.put(shortUrl, url);
        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl) {
        Url url = urlStore.get(shortUrl);
        return url != null ? url.getOriginalUrl() : null;
    }
}
