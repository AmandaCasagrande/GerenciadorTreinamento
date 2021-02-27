package br.com.empresa.gestaocadastro.dto;

import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;
import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GerarTreinamentoDTO {

	private ParticipanteEntity participante;
	private SalaEventoDTO salaPrimeiraEtapa;
	private SalaEventoDTO salaSegundaEtapa;
	private EspacoCafeEntity cafePrimeiraEtapa;
	private EspacoCafeEntity cafeSegundaEtapa;
	private String erros;
	
	public GerarTreinamentoDTO(String erro) {
		this.erros = erro;
	}
}
