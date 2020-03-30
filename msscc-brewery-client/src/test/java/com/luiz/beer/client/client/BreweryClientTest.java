package com.luiz.beer.client.client;

import com.luiz.beer.client.model.BeerDto;
import com.luiz.beer.client.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeer() {
        BeerDto beerDto = breweryClient.getBeer(UUID.randomUUID());
        assertThat(beerDto).isNotNull();
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Corona").build();
        URI uri = breweryClient.saveNewBeer(beerDto);
        assertThat(uri).isNotNull();
    }

    @Test
    void testUpdateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Pinlsen").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void testCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertThat(customerDto).isNotNull();

    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Luiz").build();
        URI uri = breweryClient.saveNewCustomer(customerDto);
        assertThat(uri).isNotNull();
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Gerald").build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }

    @Test
    void testGetUrl() {
        String url = breweryClient.getUrl();
        assertThat(url).isNotEmpty();
    }
}