package org.example.demo.springboot.webapp.controllers;

import org.example.demo.springboot.webapp.configuration.SpringConfiguration;
import org.example.demo.springboot.webapp.controllers.ProjetController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {ProjetController.class})
@ContextConfiguration(classes = {SpringConfiguration.class})
class ProjetControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testProjetsRequest() throws Exception{
        mockMvc.perform(get("/projets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].nom").value("Anneau"))
                .andExpect(jsonPath("$[2].responsable.nom").value("Bracame"))
                .andDo(print());
    }

}
