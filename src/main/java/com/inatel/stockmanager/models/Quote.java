package com.inatel.stockmanager.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="quote")
@Getter
@Setter
public class Quote implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	private LocalDate dtQuote;
	@NotNull
	private BigDecimal value;
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="stockId", nullable=false)
	private Stock stock;
	@NotNull
	private OffsetDateTime dtCadastro;
}
