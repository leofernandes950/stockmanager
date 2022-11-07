package com.inatel.stockmanger.models;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="stock")
@Getter
@Setter
public class Stock {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;
	@Column(name = "stockId")
	@NotNull
	private String stockId;
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
	private Set<Quote> quotes;

}
