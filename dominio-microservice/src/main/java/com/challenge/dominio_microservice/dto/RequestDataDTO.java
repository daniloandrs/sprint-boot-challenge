package com.challenge.dominio_microservice.dto;

import lombok.Data;

@Data
public class RequestDataDTO {
    private String FullName;
	private String country;
	private String Address;
	private String zipCode;

}
