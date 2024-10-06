package org.example.urlshortener.controller;

import org.example.urlshortener.service.UrlShortenerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    private UrlShortenerService urlService;

    public void UrlController(UrlShortenerService urlService) {
        this.urlService = urlService;
    }

    public UrlShortenerController(UrlShortenerService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public String shortenUrl(@RequestBody String originalUrl) {
        String shortUrl = urlService.shortenUrl(originalUrl);
        return "http://tny.url/:" + shortUrl;
    }

    @GetMapping("/{shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        String originalUrl = urlService.getOriginalUrl(shortUrl);
        if (originalUrl == null) {
            throw new RuntimeException("URL not found");
        }
        return originalUrl; // In a real app, you would redirect here
    }
}
