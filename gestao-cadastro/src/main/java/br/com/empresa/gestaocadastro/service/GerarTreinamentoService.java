package br.com.empresa.gestaocadastro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.gestaocadastro.dto.GerarTreinamentoDTO;
import br.com.empresa.gestaocadastro.dto.SalaEventoDTO;
import br.com.empresa.gestaocadastro.dto.form.GerarTreinamentoForm;
import br.com.empresa.gestaocadastro.entities.EspacoCafeEntity;
import br.com.empresa.gestaocadastro.entities.ParticipanteEntity;
import br.com.empresa.gestaocadastro.repository.EspacosCafeRepository;
import br.com.empresa.gestaocadastro.repository.ParticipanteRepository;
import br.com.empresa.gestaocadastro.repository.SalaEventoRepository;

@Service
public class GerarTreinamentoService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	@Autowired
	private SalaEventoRepository salaEventoRepository;
	@Autowired
	private EspacosCafeRepository espacosCafeRepository;

	private int indiceUltimaSala = -1;
	
	public List<GerarTreinamentoDTO> gerar(GerarTreinamentoForm gerarTreinamentoForm){
		List<GerarTreinamentoDTO> listaResultado = new ArrayList<GerarTreinamentoDTO>();
		
		List<ParticipanteEntity> listaParticipante = participanteRepository.findAll();
		List<SalaEventoDTO> listaSalaEventoDTO = salaEventoRepository.findAll().stream().map(SalaEventoDTO::new).collect(Collectors.toList());
		
		validarLotacao(listaParticipante, listaSalaEventoDTO);
		
		EspacoCafeEntity cafe1 = buscarEspacoCafe(gerarTreinamentoForm.getIdEspaco1());
		EspacoCafeEntity cafe2 = buscarEspacoCafe(gerarTreinamentoForm.getIdEspaco2());
		
		for (ParticipanteEntity participante : listaParticipante) {
			GerarTreinamentoDTO resultado = new GerarTreinamentoDTO();
			resultado.setParticipante(participante);
			resultado.setSalaPrimeiraEtapa(pegarProximaSalaDisponivel(listaSalaEventoDTO));
			resultado.setSalaSegundaEtapa(null);
			resultado.setCafePrimeiraEtapa(cafe1);
			resultado.setCafeSegundaEtapa(cafe2);
			
			listaResultado.add(resultado);
		}
		
		zerarLotacaoAposPrimeiraEtapa(listaSalaEventoDTO);
		
		for (GerarTreinamentoDTO treinamento : listaResultado) {
			treinamento.setSalaSegundaEtapa(pegarProximaSalaDisponivel(listaSalaEventoDTO));
		}

		return listaResultado;
	}

	private void zerarLotacaoAposPrimeiraEtapa(List<SalaEventoDTO> listaSalaEventoDTO) {
		this.indiceUltimaSala = 0;
		listaSalaEventoDTO.forEach(sala -> {
			sala.setLotacaoAtual(0);
		});
	}

	private EspacoCafeEntity buscarEspacoCafe(Long idEspacoCafe) {
		Optional<EspacoCafeEntity> espacoCafe = espacosCafeRepository.findById(idEspacoCafe);
		
		if (espacoCafe.isEmpty()) {
			throw new ServiceException("Não foi localizado um espaço de café com o id: " + idEspacoCafe);
		}
		
		return espacoCafe.get();
	}

	private void validarLotacao(List<ParticipanteEntity> listaParticipante, List<SalaEventoDTO> listaSalaEventoDTO) {
		Integer lotacaoMaxima = pegarTotalLotacao(listaSalaEventoDTO);
		
		int qtdParticipantes = listaParticipante.size();
		if (qtdParticipantes > lotacaoMaxima) {
			throw new ServiceException("Quantidade de participantes excede a lotacao máxima das salas!");
		}
	}

	private Integer pegarTotalLotacao(List<SalaEventoDTO> listaSalaEventoDTO) {
		Integer lotacaoMaxima = listaSalaEventoDTO.stream()
				.map(SalaEventoDTO::getLotacaoTotalSalaEvento)
				.reduce(Integer.valueOf(0), this::Somar);
		return lotacaoMaxima;
	}

	private SalaEventoDTO pegarProximaSalaDisponivel(List<SalaEventoDTO> listaSalaEventoDTO) {
		SalaEventoDTO sala = pegarProximaSala(listaSalaEventoDTO);
		while (salaSemEspacoDisponivel(sala)) {
			sala = pegarProximaSala(listaSalaEventoDTO);
		}
		
		sala.setLotacaoAtual(sala.getLotacaoAtual() + 1);
		return sala;
	}

	private boolean salaSemEspacoDisponivel(SalaEventoDTO sala) {
		return sala.getLotacaoAtual() > sala.getLotacaoTotalSalaEvento();
	}

	private SalaEventoDTO pegarProximaSala(List<SalaEventoDTO> listaSalaEvento) {
		this.indiceUltimaSala++;
		
		if (this.indiceUltimaSala > listaSalaEvento.size() - 1) {
			this.indiceUltimaSala = 0;
		}
		
		return listaSalaEvento.get(this.indiceUltimaSala);
	}

	private Integer Somar(Integer int1, Integer int2) {
		return int1 + int2;
	}

}
