package com.inatel.stockmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.inatel.stockmanager.models.dto.StockRequestDTO;
import com.inatel.stockmanager.service.StockService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
	@Autowired
	private StockService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Stock salvar(@RequestBody @Valid StockRequestDTO stockRequestDTO) {
		return this.service.salvar(stockRequestDTO);
	}

	@GetMapping("{stockId}")
	public ResponseEntity<Stock> buscar(@PathVariable @Valid String stockId) {
		return this.service.buscar(stockId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public List<Stock> buscarTodos(){
		return this.service.buscarTodos();
	}
	
	@PutMapping
	public ResponseEntity<Stock> atualizar(@RequestBody @Valid StockRequestDTO stockRequestDTO) {
		if(!service.existsById(stockRequestDTO.getStockId())) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(service.salvar(stockRequestDTO));
	}
	
	@DeleteMapping("/{stockId}")
	public ResponseEntity<Stock> apagar(@PathVariable("stockId") String stockId){
		this.service.deleteById(stockId);
		return ResponseEntity.ok().build();
	}
}
