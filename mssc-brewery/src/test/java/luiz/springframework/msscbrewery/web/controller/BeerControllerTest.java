package luiz.springframework.msscbrewery.web.controller;

import luiz.springframework.msscbrewery.services.BeerService;
import luiz.springframework.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerTest {

    @Autowired
    BeerService beerService;

    @Test
    void getBeer() {

        BeerDto beerDto = beerService.getBeer(UUID.randomUUID());

        assertNotNull(beerDto);
    }
}