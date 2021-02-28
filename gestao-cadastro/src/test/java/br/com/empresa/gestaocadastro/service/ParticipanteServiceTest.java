package br.com.empresa.gestaocadastro.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

	@Test
	public void consultarTeste() {
		when(participanteRepository.findById(any())).thenReturn(criarParticipanteEntityOptional("Amanda", "Oliveira"));
		
		ParticipanteDTO consultar = participanteService.consultar(1L);
		
		assertEquals("Amanda", consultar.getPrimeiroNomePessoa());
		
	}
	
	@Test
	public void atualizarTeste() {
		ParticipanteForm participante = new ParticipanteForm("Amanda", "Casagrande");
		Optional<ParticipanteEntity> participanteOptional = criarParticipanteEntityOptional("Amanda", "Oliveira");
		
		when(participanteRepository.findById(any())).thenReturn(participanteOptional);
		when(participanteRepository.save(any())).thenReturn(participanteOptional.get());

		ParticipanteDTO atualizar = participanteService.atualizar(1L, participante);
		
		assertEquals("Amanda", atualizar.getPrimeiroNomePessoa());
		assertEquals("Casagrande", atualizar.getSobrenomePessoa());
	}
	
	@Test
	public void deletarTeste() {
		when(participanteRepository.findById(any())).thenReturn(criarParticipanteEntityOptional("Amanda", "Oliveira"));
		
		participanteService.deletar(1L);
		
		Mockito.verify(participanteRepository).delete(any());
	}
	
	private ParticipanteEntity criarParticipanteEntity(ParticipanteForm participante) {
		ParticipanteEntity participanteEntity = new ParticipanteEntity();
		participanteEntity.setId(1L);
		participanteEntity.setNomeParticipante(participante.getNomeParticipante());
		participanteEntity.setSobrenomeParticipante(participante.getSobrenomeParticipante());
		return participanteEntity;
	}
	
	private Optional<ParticipanteEntity> criarParticipanteEntityOptional(String nome, String sobrenome) {
		ParticipanteEntity participante = new ParticipanteEntity();
		participante.setId(1L);
		participante.setNomeParticipante(nome);
		participante.setSobrenomeParticipante(sobrenome);
		return Optional.of(participante);
	}
}
