package com.url_shortener.url_shortener.controller;

import com.url_shortener.url_shortener.service.UrlShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UrlShortenerController {
    private final UrlShortenerService service;
    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }
    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestBody String longUrl) {
        String shortCode = service.shortenUrl(longUrl);
        return ResponseEntity.ok("http://localhost:8080/" + shortCode);
    }
    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode) {
        System.out.println("get");
        return service.getLongUrl(shortCode)
                .map(url -> ResponseEntity.status(302).location(URI.create(url)).build())
                .orElse(ResponseEntity.notFound().build());
    }
}