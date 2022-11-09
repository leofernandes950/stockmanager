package com.inatel.stockmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inatel.stockmanager.models.Stock;
import com.inatel.stockmanager.models.embeddable.StockId;
import com.inatel.stockmanager.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	@Transactional
	public Stock salvar(Stock Stock) {
		return this.repository.save(Stock);
	}

	public Optional<Stock> buscar(StockId stockId) {
		return this.repository.findById(stockId);
	}

	public List<Stock> buscarTodos() {
		return this.repository.findAll();
	}

	public void deleteById(StockId stockId) {
		this.repository.deleteById(stockId);
	}
	
	public boolean existsById(StockId stockId) {
		return this.repository.existsById(stockId);
	}
}
