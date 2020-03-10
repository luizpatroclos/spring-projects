package com.luiz.beer.client.client;

import com.luiz.beer.client.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeer() {

        BeerDto beerDto = breweryClient.getBeer(UUID.randomUUID());

        assertNotNull(breweryClient);
    }
}