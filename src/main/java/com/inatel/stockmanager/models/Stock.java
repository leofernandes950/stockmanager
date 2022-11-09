package com.inatel.stockmanager.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.inatel.stockmanager.models.embeddable.StockId;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stock")
@Getter
@Setter
public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StockId stockId;
	
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Quote> quotes;

}
