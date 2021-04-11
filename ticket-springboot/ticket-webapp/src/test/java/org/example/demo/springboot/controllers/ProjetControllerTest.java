package org.example.demo.springboot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = {ProjetController.class})
public class ProjetControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testProjetsRequest() throws Exception{
        mockMvc.perform(get("/projets")).andDo(print());

    }

}
