package luiz.springframework.msscbrewery.services;

import lombok.extern.slf4j.Slf4j;
import luiz.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomer(UUID uuid) {
        return CustomerDto.builder().uuid(UUID.randomUUID())
            .name("Luiz Albuquerque").build();
    }

    @Override
    public void deleteCustomer(UUID customerId) {

        //todo "Delete"customer according to the database sure
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {

        log.info("Must be implemented. Some services to persist in DB");

    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {

        log.debug("Save new Customer !");

        return CustomerDto.builder().uuid(customerDto.uuid)
            .name("José")
            .build();
    }

}
