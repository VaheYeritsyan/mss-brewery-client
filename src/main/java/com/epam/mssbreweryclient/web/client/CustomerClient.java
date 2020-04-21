package com.epam.mssbreweryclient.web.client;

import com.epam.mssbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "my.customer",ignoreUnknownFields = false)
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 ="/api/v1/customer/";
    private String apiHost;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate=restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID id){
        return restTemplate.getForObject(apiHost+ CUSTOMER_PATH_V1 +id,CustomerDto.class);
    }

    public URI addNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost+ CUSTOMER_PATH_V1,customerDto);
    }

    public void updateBeer(UUID id,CustomerDto customerDto){
        restTemplate.put(apiHost+ CUSTOMER_PATH_V1 +id,customerDto);
    }

    public void deleteBeerById(UUID id){
        restTemplate.delete(apiHost+ CUSTOMER_PATH_V1 +id);
    }

}
