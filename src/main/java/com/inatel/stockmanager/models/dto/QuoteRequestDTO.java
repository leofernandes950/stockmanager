package com.inatel.stockmanager.models.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
	private UUID id;
	@NotNull
    private String stockId;
	@NotNull
	private List<QuoteRecord> quotes;
	public record QuoteRecord(LocalDate dtQuote,BigDecimal value) {}

}
