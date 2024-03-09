package com.armando.price.spring.repository;

import com.armando.price.spring.entities.Price;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByProductIdAndBrandId( Long productId, Long brandId);
}
