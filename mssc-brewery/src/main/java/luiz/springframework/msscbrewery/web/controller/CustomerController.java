package luiz.springframework.msscbrewery.web.controller;

import luiz.springframework.msscbrewery.services.CustomerService;
import luiz.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {

        return new ResponseEntity<>(customerService.getCustomer(customerId), HttpStatus.OK);

    }

    @PostMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> handlePost(@PathVariable("customerId") @RequestBody CustomerDto customerDto) {


        CustomerDto saveCustomer  = customerService.saveNewCustomer(customerDto);

        HttpHeaders header = new HttpHeaders();

        header.add("Location", "/api/v1/customer/" + saveCustomer.uuid.toString());

        return new ResponseEntity<>(header, HttpStatus.ACCEPTED);

    }

    @PutMapping({"/{customerDto}"})
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerDto") @RequestBody CustomerDto customerDto) {

        customerService.updateCustomer(customerDto);

        HttpHeaders header = new HttpHeaders();

        header.add("Location", "/api/v1/customer/" + customerDto.toString());

        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteCustomer(customerId);
    }
}
