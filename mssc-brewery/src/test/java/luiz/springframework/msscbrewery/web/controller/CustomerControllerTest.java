package luiz.springframework.msscbrewery.web.controller;

import luiz.springframework.msscbrewery.services.CustomerService;
import luiz.springframework.msscbrewery.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerControllerTest {


    @Autowired
    CustomerService customerService;


    @Test
    void getCustomer() {

        CustomerDto customerDto = customerService.getCustomer(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void handlePost() {

    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }
}