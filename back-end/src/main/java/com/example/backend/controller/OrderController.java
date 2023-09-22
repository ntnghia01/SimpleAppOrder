package com.example.backend.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.backend.request.OrderRequest;
import com.example.backend.response.ScalapayOrderResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final String SCALAPAY_API_URL = "https://api.scalapay.com/v2/orders";
    private final String SCALAPAY_API_KEY = "qhtfs87hjnc12kkos";
    @PostMapping
    public ResponseEntity<ScalapayOrderResponse> createOrder(@RequestBody OrderRequest orderDataJson) {
        try {
            // Create HttpHeaders
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + SCALAPAY_API_KEY);

            // Create HttpEntity
            HttpEntity<OrderRequest> request = new HttpEntity<>(orderDataJson, headers);

            // Using RestTemplate (POST request to Scalapay API)
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<ScalapayOrderResponse> response = restTemplate.postForEntity(SCALAPAY_API_URL, request, ScalapayOrderResponse.class);

            // Checking response from Scalapay
            if (response.getStatusCode() == HttpStatus.OK) {
                // Request successfully
                return response;
            } else {
                // Request failed
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ScalapayOrderResponse());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ScalapayOrderResponse());
        }
        
    }

}
