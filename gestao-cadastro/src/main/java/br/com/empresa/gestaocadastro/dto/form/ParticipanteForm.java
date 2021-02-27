package br.com.empresa.gestaocadastro.dto.form;

import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParticipanteForm {
	
	private String nomeParticipante;
	private String sobrenomeParticipante;
	
	public ParticipanteForm(ParticipanteEntity participanteEntity) {
		this.nomeParticipante = participanteEntity.getNomeParticipante();
		this.sobrenomeParticipante = participanteEntity.getSobrenomeParticipante();
	}
}
