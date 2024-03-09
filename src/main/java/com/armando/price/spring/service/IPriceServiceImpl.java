package com.armando.price.spring.service;

import com.armando.price.spring.entities.Price;
import com.armando.price.spring.repository.PriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class IPriceServiceImpl implements IPriceService {


    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> getPrice(Long productId, Long brandId) {
        this.insertPrice();
        return priceRepository.findByProductIdAndBrandId(productId, brandId);
    }
        
    @SuppressWarnings({ "null", "deprecation" })
    public void insertPrice() {
    
    if (priceRepository.count() > 0) {
           return;
    }
    
    // Crear una lista para almacenar los nuevos registros
    List<Price> prices = new ArrayList<>();

    // Agregar cada objeto Price a la lista
    prices.add(createPrice(1L, new Date(120, 6, 14, 0, 0,0), new Date(120, 12, 31, 23, 59,59), 35455L, 0, 35.50, "EUR"));
    prices.add(createPrice(1L, new Date(120, 6, 14, 15, 0,0), new Date(120, 6, 14, 18, 30,0), 35455L, 1, 25.45, "EUR"));
    prices.add(createPrice(1L, new Date(120, 6, 15, 0, 0,0), new Date(120, 6, 15, 11, 0,0), 35455L, 1, 30.50, "EUR"));
    prices.add(createPrice(1L, new Date(120, 6, 15, 16, 0,0), new Date(120, 12, 31, 23, 59,59), 35455L, 1, 38.95, "EUR"));

    try {
        
            // Guardar todos los registros de Price en la base de datos
        priceRepository.saveAll(prices);

    } catch (Exception e) {
        System.out.println("error " + e.getMessage());
    }


    // Recuento después de la inserción
    long countAfterInsertion = priceRepository.count();
    System.out.println("Número total de registros : " + countAfterInsertion);
}

        private Price createPrice(Long brandId, Date startDate, Date endDate, Long productId, int priority, double price, String currency) {
            Price priceObj = new Price();
            priceObj.setBrandId(brandId);
            priceObj.setStartDate(startDate);
            priceObj.setEndDate(endDate);
            priceObj.setProductId(productId);
            priceObj.setPriority(priority);
            priceObj.setPrice(price);
            priceObj.setCurrency(currency);
            return priceObj;
        }
}
