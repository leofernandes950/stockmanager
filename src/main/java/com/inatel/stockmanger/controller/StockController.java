package com.inatel.stockmanger.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inatel.stockmanger.models.Stock;
import com.inatel.stockmanger.service.StockService;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
	private StockService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Stock salvar(@RequestBody @Valid Stock stock) {
		return this.service.salvar(stock);
	}
}
