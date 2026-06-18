package com.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

// Raamatud valisest API-st (itbook.store), paringut teeb back-end (mitte front-end otse)
@RestController
@RequestMapping("/api/external")
@CrossOrigin(origins = "http://localhost:3000")
public class ExternalBookController {

    private final RestClient restClient = RestClient.create();

    @GetMapping("/books")
    public ResponseEntity<String> getExternalBooks(@RequestParam(defaultValue = "1") int page) {
        String url = "https://api.itbook.store/1.0/search/react?page=" + page;
        try {
            String body = restClient.get()
                    .uri(url)
                    .retrieve()
                    .body(String.class);
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(body);
        } catch (Exception e) {
            // Valine API ei vasta (nt teenus maas) - anname selge teate, mitte 500
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"error\":\"Valise API-ga (api.itbook.store) ei saanud uhendust\",\"details\":\""
                            + e.getMessage() + "\"}");
        }
    }
}
