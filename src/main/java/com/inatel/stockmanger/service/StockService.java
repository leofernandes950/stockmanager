package com.inatel.stockmanger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inatel.stockmanger.models.Stock;
import com.inatel.stockmanger.models.embeddable.StockId;
import com.inatel.stockmanger.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	@Transactional
	public Stock salvar(Stock Stock) {
		return this.repository.save(Stock);
	}

	public Optional<Stock> buscar(String stockId) {
		return this.repository.findByStockId(stockId);
	}

	public List<Stock> buscarTodos() {
		return this.repository.findAll();
	}

	public void deleteById(StockId id) {
		this.repository.deleteById(id);
	}
}
