package br.com.vainaweb.escolat1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat1.dto.DadosColaborador;
import br.com.vainaweb.escolat1.model.ColaboradorModel;
//import br.com.vainaweb.escolat1.model.Endereco;
import br.com.vainaweb.escolat1.repository.ColaboradorRepository;

@Service 
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repository;

	public List<ColaboradorModel> encontrarTodos() {
		return repository.findAll();
	}

	public String cadastrar(DadosColaborador dados) {
		repository.save(new ColaboradorModel(dados.nome(), dados.email(), dados.cpf(), dados.cargo(), dados.endereco()));
		return "ok";
	}
}