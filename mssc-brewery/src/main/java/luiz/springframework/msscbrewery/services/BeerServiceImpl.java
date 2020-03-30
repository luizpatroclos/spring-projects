package luiz.springframework.msscbrewery.services;

import lombok.extern.slf4j.Slf4j;
import luiz.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements  BeerService {

    @Override
    public BeerDto getBeer(UUID beerId) {

        return BeerDto.builder()
            .id(UUID.randomUUID())
            .beerName("Luiz")
            .beerStyle("Patroclos")
            .cd(99L)
            .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
            .id(UUID.randomUUID())
            .build();
    }

    @Override
    public void updateBeerDto(UUID beerId, BeerDto beerDto) {

        //todo we should implement something here to update our beer in the data base
    }

    @Override
    public void deleteBeer(UUID beerId) {

        log.info("This method is supposed to be implemented by someone who wants to persist in the data base");
    }


}
