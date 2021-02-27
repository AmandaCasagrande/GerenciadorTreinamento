package br.com.empresa.gestaocadastro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;

@Repository
public interface ParticipanteRepository extends CrudRepository<ParticipanteEntity, Long>{
	
	 Optional<ParticipanteEntity> findFirstByNomeParticipante(String nomeParticipante);

	 List<ParticipanteEntity> findAll();
}

