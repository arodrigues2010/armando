package com.armando.price.spring.service;

import java.util.Date;
import java.util.List;

import com.armando.price.spring.entities.Price;


public interface IPriceService {
     List<Price> getPrice(Long productId, Long brandId);
}
