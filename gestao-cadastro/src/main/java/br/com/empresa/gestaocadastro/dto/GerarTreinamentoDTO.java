package br.com.empresa.gestaocadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GerarTreinamentoDTO {

	private Long id;
	private String entradaSala;
	private String saidaSala;
	private String entradaCafe;
	private String saidaCafe;
	/*
	public GerarTreinamentoDTO(MovimentacoesEntity movimentacao) {
		this.id = movimentacao.getId();
		this.entradaSala = movimentacao.getEntradaSala();
		this.saidaSala = movimentacao.getSaidaSala();
		this.entradaCafe = movimentacao.getEntradaCafe();
		this.saidaCafe = movimentacao.getSaidaCafe();

	}
*/
}
