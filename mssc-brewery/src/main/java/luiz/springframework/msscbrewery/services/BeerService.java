package luiz.springframework.msscbrewery.services;

import luiz.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeer(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeerDto(UUID beerId, BeerDto beerDto);
}
