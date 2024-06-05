package com.challenge.orquestador_microservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrquestadorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testProcesar() throws Exception {
        String json = "{\"fullName\": \"Danilo Andres Marcelo\",\"country\": \"Perú\",\"Address\": \"Piura Perú\",\"zipCode\": \"20000\"}";

        mockMvc.perform(post("/orquestador/proccess")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
