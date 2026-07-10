package de.kurs.devops;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integrationstest fuer einen REST-Endpunkt.
 *
 * Im Gegensatz zum reinen Unit-Test wird hier ein Teil des Spring-Kontextes
 * verwendet. Dadurch sehen die Teilnehmenden den Unterschied zwischen
 * Fachlogik-Test und API-Test.
 */
@SpringBootTest
@AutoConfigureMockMvc
class ReadingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void differenceEndpointReturnsCalculatedValue() throws Exception {
        mockMvc.perform(get("/api/difference")
                        .param("meterNumber", "M-100")
                        .param("oldCounter", "100")
                        .param("newCounter", "135"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.meterNumber").value("M-100"))
                .andExpect(jsonPath("$.difference").value(35));
    }
}
