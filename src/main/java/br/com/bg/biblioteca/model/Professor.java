package br.com.bg.biblioteca.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.bg.biblioteca.enums.Genero;

@Entity
public class Professor extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable(
			name = "cursos_professores",
			joinColumns = {@JoinColumn(name= "professor_id")},
			inverseJoinColumns = @JoinColumn(name = "curso_id")
			)
	//@JsonManagedReference(value = "professorCursos")
	@JsonBackReference
	private List<Curso> cursos;
	
	@OneToOne
	@JsonBackReference(value = "bibliotecaProfessores")
	private Biblioteca biblioteca;

	public Professor(long id, String nome, String cpf, Genero genero, Endereco endereco, Contato contato, Login login,
			List<Curso> cursos, Biblioteca biblioteca) {
		super(id, nome, cpf, genero, endereco, contato, login);
		this.cursos = cursos;
		this.biblioteca = biblioteca;
	}

	public Professor() {
		
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
}
