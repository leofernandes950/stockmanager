package com.inatel.stockmanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inatel.stockmanager.models.Stock;
import com.inatel.stockmanager.models.dto.QuoteRequestDTO;
import com.inatel.stockmanager.service.QuoteManager;

@RestController
@RequestMapping(value = "/quoteManager")
public class QuoteManagerController {
	
	@Autowired
	private QuoteManager manager;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public QuoteRequestDTO salvar(@RequestBody @Valid QuoteRequestDTO quoteRequestDTO) throws Exception {
		return this.manager.salvar(quoteRequestDTO);
	}

	@GetMapping("/enableDisable/{stockId}")
	public ResponseEntity<Stock> enableDisableStock(@PathVariable String stockId, @RequestParam boolean enableDisable) {
		return this.manager.enableDisableStock(stockId, enableDisable).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/findByStock/{stockId}")
	public ResponseEntity<QuoteRequestDTO> findByStockId(@PathVariable String stockId){
		return this.manager.findByStockId(stockId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
