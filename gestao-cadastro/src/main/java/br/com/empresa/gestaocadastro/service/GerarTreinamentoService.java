package br.com.empresa.gestaocadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.gestaocadastro.dto.GerarTreinamentoDTO;
import br.com.empresa.gestaocadastro.dto.form.GerarTreinamentoForm;
import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import br.com.empresa.gestaocadastro.repository.ParticipanteRepository;

@Service
public class GerarTreinamentoService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public GerarTreinamentoDTO gerar(GerarTreinamentoForm gerarTreinamentoForm) {
		Iterable<ParticipanteEntity> participantes = participanteRepository.findAll();
		
		while (participantes.iterator().hasNext()) {
			
		}
		
		return null;
	
	}

}
