package com.example.eyali.socialmultiplication.service;

import com.example.eyali.socialmultiplication.domain.Multiplication;
import com.example.eyali.socialmultiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();

    boolean checkAttempt(MultiplicationResultAttempt resultAttempt);

}
