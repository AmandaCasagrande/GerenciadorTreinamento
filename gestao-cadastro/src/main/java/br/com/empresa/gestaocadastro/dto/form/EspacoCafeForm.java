package br.com.empresa.gestaocadastro.dto.form;

import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EspacoCafeForm {
	
	private String nomeEspacoCafe;
	private Integer lotacaoEspacoCafe;
	
	public EspacoCafeForm(EspacoCafeEntity espacoEntity) {
		this.nomeEspacoCafe = espacoEntity.getNomeEspacoCafe();
		this.lotacaoEspacoCafe = espacoEntity.getLotacaoEspacoCafe();
	}
	
}
