package com.example.eyali.socialmultiplication.controller;

import com.example.eyali.socialmultiplication.domain.Multiplication;
import com.example.eyali.socialmultiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
public class MultipleCalculationController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultipleCalculationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping("/random")
    public Multiplication getRandomMultiplication(){
        return multiplicationService.createRandomMultiplication();
    }



}
