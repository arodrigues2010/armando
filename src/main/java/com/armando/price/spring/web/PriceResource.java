package com.armando.price.spring.web;

import com.armando.price.spring.entities.Price;
import com.armando.price.spring.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PriceResource {

    public PriceResource() {
        System.out.println("*** HomeController ***");
    }
    
    @Autowired
    private IPriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<List<Price>> getPrice(
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {

        List<Price> prices = priceService.getPrice( productId, brandId);
        if (prices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }


}
