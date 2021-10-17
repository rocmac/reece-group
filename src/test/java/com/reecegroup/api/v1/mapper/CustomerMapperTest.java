package com.reecegroup.api.v1.mapper;

import com.reecegroup.api.v1.model.CustomerDTO;
import com.reecegroup.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    public static final String FIRSTNAME = "Jimmy";
    public static final String LASTNAME = "Fallon";
    public static final String PHONENUMBER = "121221";
    public static final Long BOOKID = 1L;
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    public void customerToCustomerDTO() throws Exception {
        //given
        Customer customer = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);
        customer.setPhonenumber(PHONENUMBER);
        customer.setBookid(BOOKID);

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(FIRSTNAME, customerDTO.getFirstname());
        assertEquals(LASTNAME, customerDTO.getLastname());
        assertEquals(PHONENUMBER, customerDTO.getPhonenumber());
        assertEquals(BOOKID, customerDTO.getBookid());

    }

}