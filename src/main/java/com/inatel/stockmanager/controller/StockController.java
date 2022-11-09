package com.inatel.stockmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inatel.stockmanager.models.Stock;
import com.inatel.stockmanager.models.embeddable.StockId;
import com.inatel.stockmanager.service.StockService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

	private StockService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Stock salvar(@RequestBody @Valid Stock stock) {
		return this.service.salvar(stock);
	}

	@GetMapping("{stockId}")
	public ResponseEntity<Stock> buscar(@PathVariable @Valid StockId stockId) {
		return this.service.buscar(stockId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public List<Stock> buscarTodos(){
		return this.service.buscarTodos();
	}
	
	@PutMapping("/{stockId}")
	public ResponseEntity<Stock> atualizar(@PathVariable("stockId") StockId stockId, @RequestBody Stock stock) {
		if(!service.existsById(stockId)) {
			return ResponseEntity.notFound().build();
		}
		
		stock.setStockId(stockId);
		stock = service.salvar(stock);
		return ResponseEntity.ok(stock);
	}
	
	@DeleteMapping("/{idPessoa}")
	public ResponseEntity<Stock> apagar(@PathVariable("stockId") StockId stockId){
		this.service.deleteById(stockId);
		return ResponseEntity.ok().build();
	}
}
