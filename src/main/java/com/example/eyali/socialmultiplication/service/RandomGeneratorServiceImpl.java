package com.example.eyali.socialmultiplication.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service("randomGeneratorService")
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

    final static int MINIMUM_FACTOR = 11;
    final static int MAXIMUM_FACTOR = 99;

    @Override
    public int generateRandomFactor() {
        return new Random().nextInt(MAXIMUM_FACTOR-MAXIMUM_FACTOR+1)+MINIMUM_FACTOR;
    }
}
