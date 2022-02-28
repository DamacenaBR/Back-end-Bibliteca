package br.com.bg.biblioteca.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.bg.biblioteca.enums.Genero;

@Entity
public class Bibliotecario extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JsonBackReference(value = "bibliotecaBibliotecarios")
	private Biblioteca biblioteca;
	
	public Bibliotecario(long id, String nome, String cpf, Genero genero, Endereco endereco,
			Contato contato, Login login, Biblioteca biblioteca) {
		super(id, nome, cpf, genero, endereco, contato, login);
		this.biblioteca = biblioteca;
	}

	public Bibliotecario() {
		super();
	}
	
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
}