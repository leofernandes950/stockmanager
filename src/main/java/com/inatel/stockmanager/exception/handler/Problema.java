package com.inatel.stockmanager.exception.handler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problema {
	
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	private int status;
	
	@Getter
	@Setter
	public static class Campo {
		
		public Campo(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}
		
		private String nome;
		private String mensagem;

	}
	
}
