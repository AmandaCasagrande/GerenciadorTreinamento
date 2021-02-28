package br.com.empresa.gestaocadastro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.empresa.gestaocadastro.dto.GerarTreinamentoDTO;
import br.com.empresa.gestaocadastro.dto.form.GerarTreinamentoForm;
import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;
import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import br.com.empresa.gestaocadastro.entities.SalaEventoEntity;
import br.com.empresa.gestaocadastro.repository.EspacosCafeRepository;
import br.com.empresa.gestaocadastro.repository.ParticipanteRepository;
import br.com.empresa.gestaocadastro.repository.SalaEventoRepository;

@ExtendWith(MockitoExtension.class)
public class GerarTreinamentoServiceTest {
	
	@InjectMocks
	private GerarTreinamentoService service;
	@Mock
	private ParticipanteRepository participanteRepository;
	@Mock
	private SalaEventoRepository salaEventoRepository;
	@Mock
	private EspacosCafeRepository espacosCafeRepository;	

	@Mock
	private GerarTreinamentoForm gerarTreinamentoForm;
	
	@Test
	public void gerarTreinamentoTest() {
		when(gerarTreinamentoForm.getIdEspaco1()).thenReturn(1l);
		when(gerarTreinamentoForm.getIdEspaco2()).thenReturn(2l);
		
		when(participanteRepository.findAll()).thenReturn(gerarListaParticipantes());
		when(salaEventoRepository.findAll()).thenReturn(gerarListaSalas());
		when(espacosCafeRepository.findById(any())).thenReturn(Optional.of(new EspacoCafeEntity()));
		
		List<GerarTreinamentoDTO> listaTreinamentoDTO = service.gerar(gerarTreinamentoForm);
		
		assertEquals(6, listaTreinamentoDTO.size());
		listaTreinamentoDTO.forEach(treinamento -> {
			assertNotEquals(treinamento.getSalaPrimeiraEtapa().getId(), treinamento.getSalaSegundaEtapa().getId());
			assertEquals(2, treinamento.getSalaPrimeiraEtapa().getLotacaoAtual());
			assertEquals(2, treinamento.getSalaSegundaEtapa().getLotacaoAtual());
		});
	}

	private List<SalaEventoEntity> gerarListaSalas() {
		List<SalaEventoEntity> result = new ArrayList<SalaEventoEntity>();
		result.add(gerarSala(1L, "Sala 1", 2));
		result.add(gerarSala(2L, "Sala 2", 2));
		result.add(gerarSala(3L, "Sala 3", 10));
		return result;
	}

	private SalaEventoEntity gerarSala(Long id, String nome, Integer lotacao) {
		SalaEventoEntity sala = new SalaEventoEntity();
		sala.setId(id);
		sala.setNomeSalaEvento(nome);
		sala.setLotacaoSalaEvento(lotacao);
		return sala;
	}

	private List<ParticipanteEntity> gerarListaParticipantes() {
		List<ParticipanteEntity> result = new ArrayList<ParticipanteEntity>();
		result.add(gerarParticipante(1L, "Amanda", "Casagrande"));
		result.add(gerarParticipante(2L, "Maria", "Machado"));
		result.add(gerarParticipante(3L, "José", "Silva"));
		result.add(gerarParticipante(4L, "Marcia", "Souza"));
		result.add(gerarParticipante(5L, "Mario", "Borges"));
		result.add(gerarParticipante(6L, "Julia", "Araujo"));
		return result;
	}

	private ParticipanteEntity gerarParticipante(Long id, String nome, String sobrenome) {
		ParticipanteEntity participante = new ParticipanteEntity();
		participante.setId(id);
		participante.setNomeParticipante(nome);
		participante.setSobrenomeParticipante(sobrenome);
		return participante;
	}
}
