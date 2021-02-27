package br.com.empresa.gestaocadastro.dto.form;

import br.com.empresa.gestaocadastro.entities.SalaEventoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SalaEventoForm {

	private String nomeSalaEvento;
	private Integer lotacaoSalaEvento;
	
	public SalaEventoForm(SalaEventoEntity salaEntity) {
		this.nomeSalaEvento = salaEntity.getNomeSalaEvento();
		this.lotacaoSalaEvento = salaEntity.getLotacaoSalaEvento();
	}
}