package com.url_shortener.url_shortener.service;


import com.url_shortener.url_shortener.model.UrlMapping;
import com.url_shortener.url_shortener.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.Optional;
@Service
public class UrlShortenerService {
    private final UrlMappingRepository repo;
    public UrlShortenerService(UrlMappingRepository repo) {
        this.repo = repo;
    }
    public String shortenUrl(String longUrl) {
        UrlMapping mapping = new UrlMapping();
        mapping.setLongUrl(longUrl);
        repo.save(mapping);
        String shortCode = encodeId(mapping.getId());
        mapping.setShortCode(shortCode);
        repo.save(mapping);
        return shortCode;
    }
    public Optional<String> getLongUrl(String shortCode) {
        return repo.findByShortCode(shortCode).map(UrlMapping::getLongUrl);
    }
    private String encodeId(Long id) {
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(id.toString().getBytes());
    }
}