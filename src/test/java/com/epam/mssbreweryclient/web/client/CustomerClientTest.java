package com.epam.mssbreweryclient.web.client;

import com.epam.mssbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {
    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void addNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("Vahe Yeritsyan").build();
        URI uri = customerClient.addNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateBeer() {
        CustomerDto customerDto = CustomerDto.builder().name("Vahe Yeritsyan").build();
        customerClient.updateBeer(UUID.randomUUID(),customerDto);
    }

    @Test
    void deleteBeerById() {
        customerClient.deleteBeerById(UUID.randomUUID());
    }
}