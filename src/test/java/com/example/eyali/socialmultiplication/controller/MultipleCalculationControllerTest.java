package com.example.eyali.socialmultiplication.controller;

import com.example.eyali.socialmultiplication.domain.Multiplication;
import com.example.eyali.socialmultiplication.service.MultiplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(MultipleCalculationController.class)
public class MultipleCalculationControllerTest {

    private JacksonTester<Multiplication> json;

    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mvc;


    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
    }


    @Test
    public void getRandomMultiplicationTest() throws Exception {
        given(multiplicationService.createRandomMultiplication())
                .willReturn(new Multiplication(70, 20));


        MockHttpServletResponse response = mvc.perform(get("/multiplications/random")
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(json.write(new Multiplication(70, 20)).getJson());

    }


}