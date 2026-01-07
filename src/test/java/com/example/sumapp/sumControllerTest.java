package com.example.sumapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.sumapp.controller.sumController;

@WebMvcTest(sumController.class)
class SumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSum() throws Exception {
        mockMvc.perform(get("/api/sum")
                .param("a", "5")
                .param("b", "7"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));
    }
}
