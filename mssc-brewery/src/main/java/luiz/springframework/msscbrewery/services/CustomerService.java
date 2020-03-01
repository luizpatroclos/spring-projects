package luiz.springframework.msscbrewery.services;


import luiz.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomer(UUID uuid);
}
