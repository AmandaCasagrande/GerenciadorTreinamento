package br.com.empresa.gestaocadastro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.empresa.gestaocadastro.dto.SalaEventoDTO;
import br.com.empresa.gestaocadastro.dto.form.SalaEventoForm;
import br.com.empresa.gestaocadastro.entities.SalaEventoEntity;
import br.com.empresa.gestaocadastro.repository.SalaEventoRepository;

@ExtendWith(MockitoExtension.class)
public class SalaEventoServiceTest {
	
	@InjectMocks
	SalaEventoService salaEventoService;
	
	@Mock
	SalaEventoRepository salaEventoRepository;
	
	@Test
	public void cadastrarTeste() {
		SalaEventoForm sala = new SalaEventoForm("Sala 1", 100);
		when(salaEventoRepository.save(any())).thenReturn(criarSalaEntity(sala));
		
		SalaEventoDTO cadastrar = salaEventoService.cadastrar(sala);
	
		assertEquals(sala.getNomeSalaEvento(), cadastrar.getNomeSalaEvento());
		assertEquals(sala.getLotacaoSalaEvento(), cadastrar.getLotacaoMaximaEvento());
	}

	@Test
	public void consultarTeste() {
		when(salaEventoRepository.findFirstByNomeSalaEvento(any())).thenReturn(criarSalaEntityOptional("Sala 1", 100));
	
		SalaEventoDTO consultar = salaEventoService.consultar("Sala 1");
		
		assertEquals("Sala 1", consultar.getNomeSalaEvento());
	}
	
	private SalaEventoEntity criarSalaEntity(SalaEventoForm sala) {
		SalaEventoEntity salaEntity = new SalaEventoEntity();
		salaEntity.setId(1L);
		salaEntity.setNomeSalaEvento(sala.getNomeSalaEvento());
		salaEntity.setLotacaoSalaEvento(sala.getLotacaoSalaEvento());
		return salaEntity;
	}
	
	private Optional<SalaEventoEntity> criarSalaEntityOptional(String nome, Integer lotacao) {
		SalaEventoEntity sala = new SalaEventoEntity();
		sala.setId(1L);
		sala.setNomeSalaEvento(nome);
		sala.setLotacaoSalaEvento(lotacao);
		return Optional.of(sala);
	}
}
