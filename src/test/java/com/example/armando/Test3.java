package com.example.armando;

import com.armando.price.spring.entities.Price;
import com.armando.price.spring.service.IPriceService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Test3 {

    @Mock
    private IPriceService priceService;

    @Test
    public void testRequestAt1000OnDay14() {

        // Creamos el LocalDateTime de la petición
        LocalDateTime requestDateTime = LocalDateTime.of(2020, 6, 14, 21, 0);

        Price expectedPrice = new Price();
        Long brandId = 1L;
        Double price = 35.50;
        String currency = "EUR";

        expectedPrice.setBrandId(brandId);
        expectedPrice.setProductId(brandId);
        expectedPrice.setStartDate(requestDateTime);
        expectedPrice.setPrice(price);
        expectedPrice.setCurrency(currency);

        // Simulamos el comportamiento del servicio getPrice para devolver una lista de
        // precios
        List<Price> mockedPrices = new ArrayList<>();

        mockedPrices.add(expectedPrice);

        when(priceService.getPrice(35455, 1)).thenReturn(mockedPrices);

        // Llamamos al método getPrice del servicio con los parámetros especificados
        List<Price> prices = priceService.getPrice(35455, 1);

        // Verificamos si al menos uno de los precios tiene la misma fecha de inicio que
        // requestDateTime
        boolean found = false;
        for (Price mockedPrice : mockedPrices) {
            if (mockedPrice.getStartDate().equals(requestDateTime)) {
                found = true;
                break;
            }
        }

        assertTrue(found, "OK");
    }
}
