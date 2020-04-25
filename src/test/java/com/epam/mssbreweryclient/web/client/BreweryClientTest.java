package com.epam.mssbreweryclient.web.client;

import com.epam.mssbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = getValidBeerDto();

        URI uri = client.saveNewBeer(beerDto);
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto =getValidBeerDto();

        client.updateBeer(UUID.randomUUID(), beerDto);

    }

    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("Gyumri")
                .beerStyle("ALE")
                .upc(2315564151L)
                .price(new BigDecimal(15.24))
                .build();
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}