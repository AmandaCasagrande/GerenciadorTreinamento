package br.com.empresa.gestaocadastro.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<List<GerarTreinamentoDTO>> gerar(@RequestBody GerarTreinamentoForm gerarTreinamentoForm, UriComponentsBuilder uriBuilder) {
		List<GerarTreinamentoDTO> gerarTreinamentoDTO;;
		try {
			gerarTreinamentoDTO = service.gerar(gerarTreinamentoForm);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(new GerarTreinamentoDTO(e.getMessage())));
		}
		
		return ResponseEntity.ok(gerarTreinamentoDTO);
	}
	
}
