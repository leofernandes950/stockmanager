package com.inatel.stockmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inatel.stockmanager.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,String>{
	
}
