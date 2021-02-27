package br.com.empresa.gestaocadastro.dto;

import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParticipanteDTO {

	private Long id;
	private String primeiroNomePessoa;
	private String sobrenomePessoa;
	
	public ParticipanteDTO (ParticipanteEntity participante) {
		this.id = participante.getId();
		this.primeiroNomePessoa = participante.getNomeParticipante();
		this.sobrenomePessoa = participante.getSobrenomeParticipante();
	}
}
