package org.example.demo.springboot.webapp.controllers;

import org.example.demo.springboot.webapp.configuration.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = {TicketController.class})
@ContextConfiguration(classes = {SpringConfiguration.class})
class TicketControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getTicket() throws Exception {
        mockMvc.perform(get("/tickets/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.numero").value("4"))
                .andExpect(jsonPath("$.titre").value("Généraliser le concept relatif"))
                .andDo(print());
    }

    @Test
    void searchTicket() throws Exception {
        mockMvc.perform(get("/tickets/search")
                    .queryParam("pProjetId","3")
                    .queryParam("pAuteurId","8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].numero").value("3"))
                .andExpect(jsonPath("$[0].description").value("Lorem ipsum dolor sit amet"))
                .andExpect(jsonPath("$[0].projet.nom").value("CB 750"))
                .andDo(print());
    }
}