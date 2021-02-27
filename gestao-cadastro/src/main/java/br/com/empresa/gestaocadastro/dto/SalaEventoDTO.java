package br.com.empresa.gestaocadastro.dto;

import br.com.empresa.gestaocadastro.entities.SalaEventoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SalaEventoDTO {

	private Long id;
	private String nomeSalaEvento;
	private Integer lotacaoTotalSalaEvento;
	private Integer lotacaoAtual;
	
	public SalaEventoDTO(SalaEventoEntity salaEntity) {
		this.id = salaEntity.getId();
		this.nomeSalaEvento = salaEntity.getNomeSalaEvento();
		this.lotacaoTotalSalaEvento = salaEntity.getLotacaoSalaEvento();
		this.lotacaoAtual = 0;
	}
	
}
