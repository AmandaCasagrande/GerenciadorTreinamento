package br.com.empresa.gestaocadastro.controller;

import java.net.URI;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.empresa.gestaocadastro.dto.EspacoCafeDTO;
import br.com.empresa.gestaocadastro.dto.form.EspacoCafeForm;
import br.com.empresa.gestaocadastro.service.EspacoCafeService;

@RestController
@RequestMapping({"MovimentacoesCafe"})
public class EspacoCafeController {
	
	@Autowired
	private EspacoCafeService service;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<EspacoCafeDTO> cadastrar(@RequestBody EspacoCafeForm espacosForm, UriComponentsBuilder uriBuilder) {
		EspacoCafeDTO espacoCafeDTO = service.cadastrar(espacosForm);
		
		URI uri = uriBuilder.path("/espacoCafe/{id}").buildAndExpand(espacoCafeDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(espacoCafeDTO);
	}
	
	@GetMapping(path = {"/{nomeEspacoCafe}"})
	public ResponseEntity<EspacoCafeDTO> consultar(@PathVariable String nomeEspacoCafe){
		EspacoCafeDTO espacoCafeDTO = service.consultar(nomeEspacoCafe);
		
		if (Objects.nonNull(espacoCafeDTO)) {
			return ResponseEntity.ok(espacoCafeDTO);
			//retornar relatório de lista de pessoas;
		} 
	
		return ResponseEntity.notFound().build();	
	}
}
 