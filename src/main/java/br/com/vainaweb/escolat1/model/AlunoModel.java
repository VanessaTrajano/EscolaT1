package br.com.vainaweb.escolat1.model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat1.dto.DadosAlunoAtualizados;
import br.com.vainaweb.escolat1.enums.Curso;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_alunos")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String telefone;
	
	@Column(unique = true) 
	@Email
	private String email;
	
	@Column(unique = true)
	@CPF 
	private String cpf;
	private Curso curso;
	
	@Embedded
	private Endereco endereco;

	// |------------------------------------------CONSTRUTORES--------------------------------------|
	public AlunoModel(String nome, String telefone, String email, String cpf, Curso curso) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.curso = curso;
	}

	
	//|------------------------------------------- MÉTODOS --------------------------------|
	
	public void atualizarInfo(@Valid DadosAlunoAtualizados dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;
		this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
		this.endereco = dados.endereco() != null ? dados.endereco() : this.endereco;
		this.curso = dados.curso() != null ? dados.curso() : this.curso;
	}
}
