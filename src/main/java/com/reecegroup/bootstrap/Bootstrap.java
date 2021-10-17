package com.reecegroup.bootstrap;

import com.reecegroup.domain.Customer;
import com.reecegroup.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner{

    private final CustomerRepository customerRepository;

    public Bootstrap(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
    }

    private void loadCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");
        customer1.setPhonenumber("111111111");
        customer1.setBookid(1L);
        customerRepository.save(customer1);
        

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Sam");
        customer2.setLastname("Axe");
        customer2.setPhonenumber("2222222");
        customer2.setBookid(2L);

        customerRepository.save(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3l);
        customer3.setFirstname("Adrian");
        customer3.setLastname("Watson");
        customer3.setPhonenumber("3333333");
        customer3.setBookid(1L);
        customerRepository.save(customer3);

        Customer customer4 = new Customer();
        customer4.setId(4l);
        customer4.setFirstname("Adrian");
        customer4.setLastname("Watson");
        customer4.setPhonenumber("3333333");
        customer4.setBookid(2L);
        customerRepository.save(customer4);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }
}
