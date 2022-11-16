package com.inatel.stockmanager.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inatel.stockmanager.models.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,UUID>{
	
	@Query("select q from Quote q where q.stock.stockId = :stockId")
	public List<Quote> findByStockId(String stockId);
}
