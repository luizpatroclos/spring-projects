package luiz.springframework.msscbrewery.web.model;

import java.util.UUID;

public class Test {



    public static void main (String ... args){




        BeerDto beer = BeerDto.builder().build();

        beer.toBuilder().id(UUID.randomUUID()).beerName("Aroldo").beerStyle("Patroclo").cd(99l);

        beer.toBuilder().id(UUID.randomUUID()).beerName("dem").beerStyle("Could").cd(99l);

        beer.toBuilder().id(UUID.randomUUID()).beerName("Marco").beerStyle("Travis").cd(99l);

        beer.toBuilder().id(UUID.randomUUID()).beerName("Polo").beerStyle("Pancho").cd(99l);

        beer.toBuilder().id(UUID.randomUUID()).beerName("Aroeira").beerStyle("Dontknow").cd(99l);


    }

}
