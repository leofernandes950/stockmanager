package com.inatel.stockmanager.models;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Id
	private String stockId;
	private String description;
	private boolean stockManaged;
	private OffsetDateTime dtCadastro;
}
