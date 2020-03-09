package com.luiz.beer.client.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder(toBuilder = true)
@Data
public class BeerDto {


    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long cd;


}
