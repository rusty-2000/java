package com.urlshortener.service;

import com.urlshortener.model.Url;
import com.urlshortener.repository.UrlRepository;
import com.urlshortener.util.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private UrlShortener urlShortener;

    public String shortenUrl(String longUrl) {
        String shortUrl = urlShortener.generateShortUrl();
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setShortUrl(shortUrl);
        url.setCreatedAt(LocalDateTime.now());
        url.setExpiresAt(LocalDateTime.now().plusMonths(10));
        urlRepository.save(url);
        return shortUrl;
    }

    public String getLongUrl(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        if (url.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("URL has expired");
        }
        return url.getLongUrl();
    }

    public boolean updateUrl(String shortUrl, String newLongUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        url.setLongUrl(newLongUrl);
        urlRepository.save(url);
        return true;
    }

    public boolean updateExpiry(String shortUrl, int daysToAdd) {
        Url url = urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
        url.setExpiresAt(url.getExpiresAt().plusDays(daysToAdd));
        urlRepository.save(url);
        return true;
    }
}