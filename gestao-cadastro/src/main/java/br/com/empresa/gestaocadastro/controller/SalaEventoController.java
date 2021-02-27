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

import br.com.empresa.gestaocadastro.dto.SalaEventoDTO;
import br.com.empresa.gestaocadastro.dto.form.SalaEventoForm;
import br.com.empresa.gestaocadastro.service.SalaEventoService;

@RestController
@RequestMapping({"MovimentacoesSalas"})
public class SalaEventoController {

	@Autowired
	private SalaEventoService service;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<SalaEventoDTO> cadastrar(@RequestBody SalaEventoForm salasForm, UriComponentsBuilder uriBuilder) {
		SalaEventoDTO salaEventoDTO = service.cadastrar(salasForm);
		
		URI uri = uriBuilder.path("/salasEvento/{id}").buildAndExpand(salaEventoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(salaEventoDTO);
	}
	
	@GetMapping(path = {"/{nomeSalaEvento}"})
	public ResponseEntity<SalaEventoDTO> consultar(@PathVariable String nomeSalaEvento){
		SalaEventoDTO salaEventoDTO = service.consultar(nomeSalaEvento);
		
		if (Objects.nonNull(salaEventoDTO)) {
			return ResponseEntity.ok(salaEventoDTO);
			//retornar relatório de lista de pessoas;
		} 
	
		return ResponseEntity.notFound().build();		
	}
	
}
