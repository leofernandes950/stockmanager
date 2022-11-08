package com.inatel.stockmanger.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inatel.stockmanger.models.Stock;
import com.inatel.stockmanger.models.embeddable.StockId;

@Repository
public interface StockRepository extends JpaRepository<Stock,StockId>{
	
	Optional<Stock> findByStockId(String stockId);
	
}
