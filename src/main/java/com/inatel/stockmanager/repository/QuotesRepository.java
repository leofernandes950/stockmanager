package com.inatel.stockmanager.repository;

import java.time.OffsetDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inatel.stockmanager.models.Quote;

@Repository
public interface QuotesRepository extends JpaRepository<Quote,OffsetDateTime>{
	
}
