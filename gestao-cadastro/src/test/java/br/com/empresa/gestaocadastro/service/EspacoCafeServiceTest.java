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

import br.com.empresa.gestaocadastro.dto.EspacoCafeDTO;
import br.com.empresa.gestaocadastro.dto.form.EspacoCafeForm;
import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;
import br.com.empresa.gestaocadastro.repository.EspacosCafeRepository;

@ExtendWith(MockitoExtension.class)
public class EspacoCafeServiceTest {

	@InjectMocks
	EspacoCafeService espacoCafeService;
	
	@Mock
	EspacosCafeRepository espacoCafeRepository;
	
	@Test
	public void cadastrarTeste() {
		EspacoCafeForm cafe = new EspacoCafeForm("Cafe 1", 20);
		when(espacoCafeRepository.save(any())).thenReturn(criarCafeEntity(cafe));
		
		EspacoCafeDTO cadastrar = espacoCafeService.cadastrar(cafe);
		
		assertEquals(cafe.getNomeEspacoCafe(), cadastrar.getNomeSalaCafe());
		assertEquals(cafe.getLotacaoEspacoCafe(), cadastrar.getLotacaoSalaCafe());
	
	}
	
	@Test
	public void consultarTeste() {
		when(espacoCafeRepository.findFirstByNomeEspacoCafe(any())).thenReturn(criarCafeEntityOptional("Cafe 1", 20));
	
		EspacoCafeDTO consultar = espacoCafeService.consultar("Sala 1");
		
		assertEquals("Cafe 1", consultar.getNomeSalaCafe());
	}

	private EspacoCafeEntity criarCafeEntity(EspacoCafeForm cafe) {
		EspacoCafeEntity cafeEntity = new EspacoCafeEntity();
		cafeEntity.setId(1L);
		cafeEntity.setNomeEspacoCafe(cafe.getNomeEspacoCafe());
		cafeEntity.setLotacaoEspacoCafe(cafe.getLotacaoEspacoCafe());
		return cafeEntity;
		
	}
	
	private Optional<EspacoCafeEntity> criarCafeEntityOptional(String nome, Integer lotacao) {
		EspacoCafeEntity cafe = new EspacoCafeEntity();
		cafe.setId(1L);
		cafe.setNomeEspacoCafe(nome);
		cafe.setLotacaoEspacoCafe(20);
		return Optional.of(cafe);
	}
}
