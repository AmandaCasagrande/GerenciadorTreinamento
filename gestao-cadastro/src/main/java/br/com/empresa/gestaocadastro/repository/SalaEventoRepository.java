package br.com.empresa.gestaocadastro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.gestaocadastro.entities.SalaEventoEntity;

@Repository
public interface SalaEventoRepository extends CrudRepository<SalaEventoEntity, Long> {
	
	Optional<SalaEventoEntity> findFirstByNomeSalaEvento(String nomeSalaEvento);

	List<SalaEventoEntity> findAll();
}
