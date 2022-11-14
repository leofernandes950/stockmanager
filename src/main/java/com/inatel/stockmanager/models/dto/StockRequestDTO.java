package com.inatel.stockmanager.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRequestDTO {
	@NotNull
	@NotBlank
	private String stockId;
	@NotNull
	@NotBlank
	private String description;

}
