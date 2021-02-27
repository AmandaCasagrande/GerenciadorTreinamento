package br.com.empresa.gestaocadastro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;

@Repository
public interface EspacosCafeRepository extends CrudRepository<EspacoCafeEntity, Long>{

	Optional<EspacoCafeEntity> findFirstByNomeEspacoCafe(String nomeEspacoCafe);

}
