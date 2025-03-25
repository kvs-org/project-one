package com.kvs.addition.controller;

import com.kvs.addition.service.AdditionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdditionController.class)
public class AdditionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AdditionService additionService;

    @Test
    void testAdditionEndpoint() throws Exception {
        // Mock the service layer
        when(additionService.add(5, 3)).thenReturn(8);

        // Perform GET request and verify the response
        mockMvc.perform(get("/add")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }

    @Test
    void testAdditionEndpointWithNegativeNumbers() throws Exception {
        // Mock the service layer
        when(additionService.add(-5, -3)).thenReturn(-8);

        // Perform GET request and verify the response
        mockMvc.perform(get("/add")
                .param("a", "-5")
                .param("b", "-3"))
                .andExpect(status().isOk())
                .andExpect(content().string("-8"));
    }

    @Test
    void testAdditionEndpointWithZero() throws Exception {
        // Mock the service layer
        when(additionService.add(5, 0)).thenReturn(5);

        // Perform GET request and verify the response
        mockMvc.perform(get("/add")
                .param("a", "5")
                .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }
}