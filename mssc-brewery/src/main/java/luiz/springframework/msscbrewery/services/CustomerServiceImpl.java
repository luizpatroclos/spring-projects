package luiz.springframework.msscbrewery.services;

import luiz.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomer(UUID uuid) {
        return CustomerDto.builder().uuid(UUID.randomUUID())
            .name("Luiz Albuquerque").build();
    }

}
