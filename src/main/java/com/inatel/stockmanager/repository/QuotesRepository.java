package com.inatel.stockmanager.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inatel.stockmanager.models.Quote;

@Repository
public interface QuotesRepository extends JpaRepository<Quote,UUID>{
	
}
