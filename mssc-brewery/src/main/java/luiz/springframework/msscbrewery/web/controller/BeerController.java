package luiz.springframework.msscbrewery.web.controller;

import luiz.springframework.msscbrewery.web.model.BeerDto;
import luiz.springframework.msscbrewery.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerService.getBeer(beerId), HttpStatus.OK);

    }


    @PostMapping // Post create a new Beer
    public ResponseEntity handlePost(BeerDto beerDto) {

        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();

        //todo add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity hadleUpdate(@PathVariable("beerId") UUID beerId, BeerDto beerDto){

        beerService.updateBeerDto(beerId, beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);   
    }

}
