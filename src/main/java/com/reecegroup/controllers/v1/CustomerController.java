package com.reecegroup.controllers.v1;

import com.reecegroup.api.v1.model.CustomerDTO;
import com.reecegroup.api.v1.model.CustomerListDTO;
import com.reecegroup.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Customer Controller")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Get a unique set of all contacts")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getListOfCustomers(){
        return new CustomerListDTO(customerService.getAllCustomers());
    }

    @ApiOperation(value = "Get a list of contacts in a address book")
    @GetMapping({"/book/{bookid}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getListOfCustomersInOneBook(@PathVariable(value = "bookid") Long bookid){
        return new CustomerListDTO(
                customerService.getCustomersByBookId(bookid)
        );
    }

    @ApiOperation(value = "Get a contact")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @ApiOperation(value = "Create a contact")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createNewCustomer(customerDTO);
    }

    @ApiOperation(value = "Update a contact")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.saveCustomerByDTO(id, customerDTO);
    }

    @ApiOperation(value = "Update a contact attribute")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        return customerService.patchCustomer(id, customerDTO);
    }

    @ApiOperation(value = "Delete a contact")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}
