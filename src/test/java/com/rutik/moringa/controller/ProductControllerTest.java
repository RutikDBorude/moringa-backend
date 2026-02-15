package com.rutik.moringa.controller;


import com.rutik.moringa.dto.ProductResponseDTO;

import com.rutik.moringa.service.ProductService;

import com.rutik.moringa.util.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @MockBean
    private JwtUtil jwtUtil;


    @Test
    void shouldReturnProducts() throws Exception {

        ProductResponseDTO dto =
                new ProductResponseDTO(1L,"Apple",100);


        Page<ProductResponseDTO> page =
                new PageImpl<>(List.of(dto),
                PageRequest.of(0,10),
                1);

        when(service.getProducts(any(),any(Pageable.class)))
                .thenReturn(page);

        mockMvc.perform(get("/products")
                        .param("page","0")
                        .param("size","10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").value("Apple"))
                .andExpect(jsonPath("$.content[0].price").value(100.0));



    }
}
