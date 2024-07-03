package com.urlshortener.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.urlshortener.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String longUrl) {
        return "http://localhost:8080/" + urlService.shortenUrl(longUrl);
    }

    @GetMapping("/{shortUrl}")
    public void redirectToLongUrl(@PathVariable String shortUrl, HttpServletResponse response) {
        try {
            String longUrl = urlService.getLongUrl(shortUrl);
            response.sendRedirect(longUrl);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "URL not found", e);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not redirect to the full URL", e);
        }
    }

    @PostMapping("/update")
    public boolean updateUrl(@RequestParam String shortUrl, @RequestParam String newLongUrl) {
        return urlService.updateUrl(shortUrl, newLongUrl);
    }

    @PostMapping("/update-expiry")
    public boolean updateExpiry(@RequestParam String shortUrl, @RequestParam int daysToAdd) {
        return urlService.updateExpiry(shortUrl, daysToAdd);
    }
}