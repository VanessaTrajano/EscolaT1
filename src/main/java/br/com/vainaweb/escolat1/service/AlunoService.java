package br.com.vainaweb.escolat1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat1.dto.DadosAluno; 
import br.com.vainaweb.escolat1.model.AlunoModel;
import br.com.vainaweb.escolat1.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public List<AlunoModel> encontrarTodos(){
		return repository.findAll();
	}
	
	public String cadastrar(DadosAluno dados) {
		var alunoExistente = repository.findByCpf(dados.cpf());
		
		if (dados.cpf() == alunoExistente.get().getCpf()) {
			return "Aluno ja existeFnte";
		} else {
			var aluno = new AlunoModel(dados.nome(), dados.telefone(), dados.email(), dados.cpf(), dados.curso());
			repository.save(aluno);
			return "Cadastro Feito";
		}
	}
}
