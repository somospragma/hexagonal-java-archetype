package com.pragma.clean_architecture.entry_points.rest.controller;

import com.pragma.clean_architecture.config.ChuckNorrisMock;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Disabled
public class JokeControllerTest {

    private final ChuckNorrisMock mockServer = new ChuckNorrisMock(9090);
    private String uriController = "/joke/random";

    @BeforeEach
    void setUp() {
        mockServer.start();
    }

    @AfterEach
    public void teardown() {
        mockServer.stop();
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(uriController)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpectAll(
                        MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
                );
    }
}
