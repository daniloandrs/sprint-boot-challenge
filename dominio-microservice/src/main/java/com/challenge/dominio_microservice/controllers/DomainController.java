package com.challenge.dominio_microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challenge.dominio_microservice.dto.RequestDataDTO;
import com.challenge.dominio_microservice.entities.DataEntity;
import com.challenge.dominio_microservice.repositories.DataRepository;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired(required = true)
    private DataRepository dataRepository;

    @PostMapping("/save")
    public ResponseEntity<String> guardar(@RequestBody RequestDataDTO requestData) {
        try {
            if (requestData == null || requestData.getFullName() == null || requestData.getFullName().isEmpty()) {
                return new ResponseEntity<>("Invalid Request", HttpStatus.BAD_REQUEST);
            }

            DataEntity dataEntity = new DataEntity();
            dataEntity.setFullName(requestData.getFullName());
            dataEntity.setCountry(requestData.getCountry());
            dataEntity.setAddress(requestData.getAddress());
            dataEntity.setZipCode(requestData.getZipCode());
            dataRepository.save(dataEntity);

            return new ResponseEntity<>("Datos guardados  correctamente.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
