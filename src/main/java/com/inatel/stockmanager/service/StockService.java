package com.inatel.stockmanager.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inatel.stockmanager.models.Stock;
import com.inatel.stockmanager.models.dto.StockRequestDTO;
import com.inatel.stockmanager.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;
	private ModelMapper mapper = new ModelMapper(); 

	@Transactional
	public Stock salvar(StockRequestDTO stockRequestDTO) {
		var stock = mapper.map(stockRequestDTO, Stock.class);
		stock.setDtCadastro(OffsetDateTime.now());
		return this.repository.save(stock);
	}
	
	@Transactional
	public Stock salvar(Stock stock) {
		return this.repository.save(stock);
	}

	public Optional<Stock> buscar(String stockId) {
		return this.repository.findById(stockId);
	}

	public List<Stock> buscarTodos() {
		return this.repository.findAll();
	}

	public void deleteById(String stockId) {
		this.repository.deleteById(stockId);
	}
	
	public boolean existsById(String stockId) {
		return this.repository.existsById(stockId);
	}
}
