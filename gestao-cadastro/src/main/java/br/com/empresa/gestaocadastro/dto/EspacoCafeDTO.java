package br.com.empresa.gestaocadastro.dto;

import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EspacoCafeDTO {

	private Long id;
	private String nomeSalaCafe;
	private Integer lotacaoSalaCafe;
	
	public EspacoCafeDTO (EspacoCafeEntity salaCafeEntity) {
		this.id = salaCafeEntity.getId();
		this.nomeSalaCafe = salaCafeEntity.getNomeEspacoCafe();
		this.lotacaoSalaCafe = salaCafeEntity.getLotacaoEspacoCafe();
	}
}
