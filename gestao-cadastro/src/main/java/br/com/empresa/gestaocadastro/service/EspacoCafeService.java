package br.com.empresa.gestaocadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.gestaocadastro.dto.EspacoCafeDTO;
import br.com.empresa.gestaocadastro.dto.form.EspacoCafeForm;
import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;
import br.com.empresa.gestaocadastro.repository.EspacosCafeRepository;

@Service
public class EspacoCafeService {

	@Autowired
	private EspacosCafeRepository espacosCafeRepository;
	
	public EspacoCafeDTO cadastrar (EspacoCafeForm salasCafeForm){
		EspacoCafeEntity espacoCafeEntity = new EspacoCafeEntity();
		
		espacoCafeEntity.setNomeEspacoCafe(salasCafeForm.getNomeEspacoCafe());
		espacoCafeEntity.setLotacaoEspacoCafe(salasCafeForm.getLotacaoEspacoCafe());
		
		return new EspacoCafeDTO(espacosCafeRepository.save(espacoCafeEntity));
	}

	
	public EspacoCafeDTO consultar (String nomeEspacoCafe){
		Optional<EspacoCafeEntity> espacoCafeEntity = espacosCafeRepository.findFirstByNomeEspacoCafe(nomeEspacoCafe);
		
		if (espacoCafeEntity.isPresent()) {
			return new EspacoCafeDTO(espacoCafeEntity.get());
		}
		
		return null;
	}
	
}
