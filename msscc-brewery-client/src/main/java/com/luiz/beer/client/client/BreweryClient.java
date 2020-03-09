package com.luiz.beer.client.client;


import com.luiz.beer.client.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "dem.conf.url", ignoreUnknownFields = true)
public class BreweryClient {

    private String idHost;

    private final String BEER_PATH = "/api/v1/beer/";

    private final RestTemplate restTemplate;

    public void setIdHost(String idHost) {
        this.idHost = idHost;
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public BeerDto getBeer(UUID uuid) {

        return restTemplate.getForObject(idHost + BEER_PATH + uuid.toString(), BeerDto.class);
    }


    public String getUrl() {
        return idHost + BEER_PATH + UUID.randomUUID().toString();
    }
}