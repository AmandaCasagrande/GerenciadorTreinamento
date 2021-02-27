package br.com.empresa.gestaocadastro.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.gestaocadastro.dto.SalaEventoDTO;
import br.com.empresa.gestaocadastro.dto.form.SalaEventoForm;
import br.com.empresa.gestaocadastro.entities.SalaEventoEntity;
import br.com.empresa.gestaocadastro.repository.SalaEventoRepository;

@Service
public class SalaEventoService {

	@Autowired
	private SalaEventoRepository salaEventoRepository;
	
	@Transactional
	public SalaEventoDTO cadastrar(SalaEventoForm salaEventoForm){
		SalaEventoEntity salaEventoEntity = new SalaEventoEntity();
		
		salaEventoEntity.setNomeSalaEvento(salaEventoForm.getNomeSalaEvento());
		salaEventoEntity.setLotacaoSalaEvento(salaEventoForm.getLotacaoSalaEvento());
		
		return new SalaEventoDTO(salaEventoRepository.save(salaEventoEntity));
	}
	
	public SalaEventoDTO consultar(String nomeSalaEvento){
		Optional<SalaEventoEntity> salaEntity = salaEventoRepository.findFirstByNomeSalaEvento(nomeSalaEvento);
		
		if (salaEntity.isPresent()) {
			return new SalaEventoDTO(salaEntity.get());
		}
		
		return null;
	}

}
