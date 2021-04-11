package org.example.demo.springboot;

import org.example.demo.springboot.business.contract.ProjetManager;
import org.example.demo.springboot.configuration.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = {SpringConfiguration.class})
class TicketWebAppApplicationTests {

    @Autowired
    ProjetManager projetManager;

    @Test
    void contextLoads() {
        assertThat(projetManager).isNotNull();
    }

}
