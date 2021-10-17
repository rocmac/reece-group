package com.reecegroup.services;

import com.reecegroup.api.v1.model.CustomerDTO;

import java.util.List;


public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getCustomersByBookId(Long bookId);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);
}
