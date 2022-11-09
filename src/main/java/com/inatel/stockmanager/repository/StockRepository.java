package com.inatel.stockmanager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inatel.stockmanager.models.Stock;
import com.inatel.stockmanager.models.embeddable.StockId;

@Repository
public interface StockRepository extends JpaRepository<Stock,StockId>{
	
	Optional<Stock> findByStockId(String stockId);
	
}
