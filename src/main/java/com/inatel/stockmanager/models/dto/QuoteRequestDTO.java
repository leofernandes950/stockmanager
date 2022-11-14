package com.inatel.stockmanager.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuoteRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
    private String stockId;
	@NotNull
	private LocalDate dtQuote;
	@NotNull
	private BigDecimal value;
}
