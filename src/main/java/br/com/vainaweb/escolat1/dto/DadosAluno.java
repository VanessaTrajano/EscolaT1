package br.com.vainaweb.escolat1.dto;

import br.com.vainaweb.escolat1.enums.Curso;

public record DadosAluno(String nome, String telefone, String cpf, String email, Curso curso) {

}
