package com.inatel.stockmanager.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inatel.stockmanager.models.Quote;
import com.inatel.stockmanager.models.Stock;
import com.inatel.stockmanager.models.dto.QuoteRequestDTO;
import com.inatel.stockmanager.models.dto.QuoteRequestDTO.QuoteRecord;
import com.inatel.stockmanager.repository.QuoteRepository;

@Service
public class QuoteManager {

	@Autowired
	private QuoteRepository repository;
	@Autowired
	private StockService stockService;

	@Transactional
	public QuoteRequestDTO salvar(QuoteRequestDTO quoteRequestDTO) throws UnsupportedOperationException {
		var stock = stockService.buscar(quoteRequestDTO.getStockId());
		var quote = new Quote();
		if (stock.isPresent()) {
			if (stock.get().isStockManaged()) {
				quoteRequestDTO.getQuotes().forEach(q -> {
					quote.setDtQuote(q.dtQuote());
					quote.setValue(q.value());
					quote.setDtCadastro(OffsetDateTime.now());
					quote.setStock(stock.get());
					repository.save(quote);
				});

			} else {
				throw new UnsupportedOperationException("O estoque deve permitir o cadastro de cotas");
			}
		} else {
			throw new UnsupportedOperationException("Estoque não encontrado.");
		}
		return quoteRequestDTO;
	}

	public Optional<Stock> enableDisableStock(String stockId, boolean enableDisable) {
		var stock = this.stockService.buscar(stockId);
		stock.ifPresent(s -> {
			s.setStockManaged(enableDisable);
			stockService.salvar(s);
		});

		return stock;
	}

	public Optional<QuoteRequestDTO> findByStockId(String stockId) {
		var quote = this.repository.findByStockId(stockId);
		var quoteRequestDTO = new QuoteRequestDTO();
		var quoteRecords = new ArrayList<QuoteRecord>();
		if (!quote.isEmpty()) {
			quote.stream().forEach(q -> 
			quoteRecords.add(new QuoteRecord(q.getDtQuote(), q.getValue()))
			);
		}
		quoteRequestDTO.setQuotes(quoteRecords);
		quoteRequestDTO.setStockId(stockId);
		return Optional.ofNullable(quoteRequestDTO);
	}
}
