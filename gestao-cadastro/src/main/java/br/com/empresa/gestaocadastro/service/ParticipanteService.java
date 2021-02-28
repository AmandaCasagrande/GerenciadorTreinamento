package br.com.empresa.gestaocadastro.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.gestaocadastro.dto.ParticipanteDTO;
import br.com.empresa.gestaocadastro.dto.form.ParticipanteForm;
import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import br.com.empresa.gestaocadastro.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	public ParticipanteDTO cadastrar (ParticipanteForm participanteForm){
		ParticipanteEntity participanteEntity = new ParticipanteEntity();
		
		participanteEntity.setNomeParticipante(participanteForm.getNomeParticipante());
		participanteEntity.setSobrenomeParticipante(participanteForm.getSobrenomeParticipante());
		
		return new ParticipanteDTO(participanteRepository.save(participanteEntity));
	}

	public ParticipanteDTO consultar(Long id){
		Optional<ParticipanteEntity> participanteEntity = participanteRepository.findById(id);
		
		if (participanteEntity.isPresent()) {
			return new ParticipanteDTO(participanteEntity.get());
		}
		
		return null;
	}
	
	public ParticipanteDTO atualizar(Long id, ParticipanteForm participanteForm){
		Optional<ParticipanteEntity> participanteEntity = participanteRepository.findById(id);
		
		if (participanteEntity.isPresent()) {
			participanteEntity.get().setNomeParticipante(participanteForm.getNomeParticipante());
			participanteEntity.get().setSobrenomeParticipante(participanteForm.getSobrenomeParticipante());
			return new ParticipanteDTO(participanteRepository.save(participanteEntity.get()));
		}
		
		return null;
	}


	public void deletar(Long id) {
		Optional<ParticipanteEntity> participanteEntity = participanteRepository.findById(id);
		
		if (participanteEntity.isPresent()) {
			try {
				participanteRepository.delete(participanteEntity.get());
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new EntityNotFoundException("Participante com id " + String.valueOf(id) + " não localizada");
		}
	}
}
