package com.challenge.orquestador_microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.challenge.orquestador_microservice.dto.OrquestadorDTO;

@RestController
@RequestMapping("/orquestador")
public class OrquestadorController {

    @Value("${domain.service}")
    private String url;

    @Autowired(required = true)
    private RestTemplate restTemplate;

    @PostMapping("/proccess")
    public ResponseEntity<String> procesar(@RequestBody OrquestadorDTO requestData) {

        try {
            if (requestData == null || requestData.getFullName() == null || requestData.getFullName().isEmpty()) {
                return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
            }
            

            ResponseEntity<String> response = restTemplate.postForEntity(
                    this.url, requestData, String.class);

            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
