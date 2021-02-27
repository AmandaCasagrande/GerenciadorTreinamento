package br.com.empresa.gestaocadastro.controller;

import java.net.URI;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.empresa.gestaocadastro.dto.ParticipanteDTO;
import br.com.empresa.gestaocadastro.dto.form.ParticipanteForm;
import br.com.empresa.gestaocadastro.service.ParticipanteService;

@RestController
@RequestMapping({"MovimentacoesUsuarios"})
public class ParticipanteController {

	@Autowired
	private ParticipanteService service;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<ParticipanteDTO> cadastrar(@RequestBody ParticipanteForm participanteForm, UriComponentsBuilder uriBuilder) {
		ParticipanteDTO participanteDTO = service.cadastrar(participanteForm);
		
		URI uri = uriBuilder.path("/participante/{id}").buildAndExpand(participanteDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(participanteDTO);
	}
	
	@GetMapping(path = {"/{nomeParticipante}"})
	public ResponseEntity<ParticipanteDTO> consultar (@PathVariable String nomeParticipante){
		ParticipanteDTO participanteDTO = service.consultar(nomeParticipante);
	
		if (Objects.nonNull(participanteDTO)) {
			return ResponseEntity.ok(participanteDTO);
			// retornar à sala em que a
			//pessoa ficará em cada etapa e o espaço onde ela realizará cada intervalo de café.
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = {"/{id}"})
	public ResponseEntity<ParticipanteDTO> atualizar(@PathVariable Long id, @RequestBody ParticipanteForm participanteForm){
		ParticipanteDTO participanteDTO = service.atualizar(id, participanteForm);
		
		if (Objects.nonNull(participanteDTO)) {
			ResponseEntity.ok(participanteDTO);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<ParticipanteDTO> deletar(@PathVariable Long id){
		try {
			service.deletar(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().build();
	}
}
