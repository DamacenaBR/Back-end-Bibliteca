package br.com.bg.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.bg.biblioteca.enums.Genero;
import br.com.bg.biblioteca.enums.Periodo;

@Entity
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JsonBackReference(value = "bibliotecaAlunos")
	private Biblioteca biblioteca;
	
	@ManyToOne
	@JsonBackReference(value = "cursoAlunos")
	private Curso curso;
	
	@Enumerated(EnumType.ORDINAL)
	private Periodo periodo;
	
	public Aluno(long id, String nome, String cpf, Genero genero, Endereco endereco, Contato contato, Login login,
			Curso curso, Biblioteca biblioteca) {
		super(id, nome, cpf, genero, endereco, contato, login);
		this.curso = curso;
		this.biblioteca = biblioteca;
	}

	public Aluno() {
		
	}
	
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
}
