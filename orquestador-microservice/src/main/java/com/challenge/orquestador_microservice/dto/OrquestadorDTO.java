package com.challenge.orquestador_microservice.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrquestadorDTO implements Serializable {
	private String FullName;
	private String country;
	private String Address;
	private String zipCode;
}
