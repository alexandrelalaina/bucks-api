package com.bucks.bucksapi.controller;

import com.bucks.bucksapi.models.Conta;
import com.bucks.bucksapi.utils.Endpoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ContaControllerTest {

    @Autowired
    MockMvc mockMvc;

//    @Autowired
//    private ContaController controller;

    @Autowired
    private ObjectMapper objectMapper;

    // setup de config do contexto, nao quero todos controllers aqui dentro

    @Test
    public void contaGetAll() throws Exception {
        mockMvc.perform(get(Endpoint.URL_CONTA))
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception {
        Conta conta = new Conta();
        conta.setDescr("Teste");
        conta.setFkContaTipo(1);
        conta.setCdSit(1);
        conta.setVlSaldo(new BigDecimal(100));

        mockMvc.perform(post(Endpoint.URL_CONTA)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(conta)))
                .andExpect(status().isCreated());
    }

}
