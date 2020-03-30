package com.luiz.beer.client.client;


import com.luiz.beer.client.model.BeerDto;
import com.luiz.beer.client.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "dem.conf.url", ignoreUnknownFields = true)
public class BreweryClient {

    private String idHost;

    private final String BEER_PATH = "/api/v1/beer/";

    private final String CUSTOMER_PATH = "/api/v1/customer/";

    private final RestTemplate restTemplate;

    public void setIdHost(String idHost) {
        this.idHost = idHost;
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    //Beer
    public BeerDto getBeer(UUID uuid) {
        return restTemplate.getForObject(idHost + BEER_PATH + uuid, BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(idHost + BEER_PATH , beerDto);
    }

    public void updateBeer( UUID uuid, BeerDto beerDto) {
        restTemplate.put(idHost + BEER_PATH + uuid, beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete( idHost + BEER_PATH + uuid);
    }

    //Customer
    public CustomerDto getCustomerById(UUID CustomerId) {
        return restTemplate.getForObject(idHost + CUSTOMER_PATH + CustomerId, CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(idHost + CUSTOMER_PATH , customerDto);
    }

    public void updateCustomer( UUID CustomerId, CustomerDto customerDto) {
        restTemplate.put(idHost + CUSTOMER_PATH + CustomerId, customerDto);
    }

    public void deleteCustomer(UUID CustomerId){
        restTemplate.delete( idHost + CUSTOMER_PATH + CustomerId);
    }

    //General
    public String getUrl() {
        return idHost + BEER_PATH + UUID.randomUUID().toString();
    }
}