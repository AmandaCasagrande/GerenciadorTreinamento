package br.com.empresa.gestaocadastro.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.empresa.gestaocadastro.dto.ParticipanteDTO;
import br.com.empresa.gestaocadastro.dto.form.ParticipanteForm;
import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import br.com.empresa.gestaocadastro.repository.ParticipanteRepository;

@ExtendWith(MockitoExtension.class)
public class ParticipanteServiceTest {

	@InjectMocks
	ParticipanteService participanteService;
	
	@Mock
	ParticipanteRepository participanteRepository;
	
	@Test
	public void cadastrarTeste() {
		ParticipanteForm participante = new ParticipanteForm("Amanda", "Casagrande");
		when(participanteRepository.save(any())).thenReturn(criarParticipanteEntity(participante));
		
		ParticipanteDTO cadastrar = participanteService.cadastrar(participante);
		
		assertEquals(participante.getNomeParticipante(), cadastrar.getPrimeiroNomePessoa());
		assertEquals(participante.getSobrenomeParticipante(), cadastrar.getSobrenomePessoa());
	}

	private ParticipanteEntity criarParticipanteEntity(ParticipanteForm participante) {
		ParticipanteEntity pe = new ParticipanteEntity();
		pe.setId(1L);
		pe.setNomeParticipante(participante.getNomeParticipante());
		pe.setSobrenomeParticipante(participante.getSobrenomeParticipante());
		return pe;
	}
	
	@Test
	public void consultarTeste() {
		
	}
	@Test
	public void atualizarTeste() {
		
	}
	
	@Test
	public void deletarTeste() {
		
	}
}
