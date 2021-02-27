package br.com.empresa.gestaocadastro.controller;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.empresa.gestaocadastro.dto.GerarTreinamentoDTO;
import br.com.empresa.gestaocadastro.dto.form.GerarTreinamentoForm;
import br.com.empresa.gestaocadastro.service.GerarTreinamentoService;

@RestController
@RequestMapping({"/gerarTreinamento"})
public class GerarTreinamentoController {

	@Autowired
	private GerarTreinamentoService service;
	
	@PostMapping 
	@Transactional
	public ResponseEntity<GerarTreinamentoDTO> gerar(@RequestBody GerarTreinamentoForm gerarTreinamentoForm, UriComponentsBuilder uriBuilder) {
		GerarTreinamentoDTO gerarTreinamentoDTO = service.gerar(gerarTreinamentoForm);
		
		URI uri = uriBuilder.path("/movimentacao/{id}").buildAndExpand(gerarTreinamentoDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(gerarTreinamentoDTO);
	}
	
}
