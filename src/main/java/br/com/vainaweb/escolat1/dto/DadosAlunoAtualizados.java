package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Curso;
import br.com.vainaweb.escolat1.model.Endereco;

public record DadosAlunoAtualizados(String nome, String telefone, Endereco endereco, Curso curso) {

}
