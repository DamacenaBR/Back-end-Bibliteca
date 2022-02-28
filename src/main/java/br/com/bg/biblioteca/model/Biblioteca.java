package br.com.bg.biblioteca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Biblioteca implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	
	private String nomeInstituicao;
	
	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "bibliotecaLivros")
	private List<Livro> livros;
	
	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "bibliotecaBibliotecarios")
	private List<Bibliotecario> bibliotecarios;
	
	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "bibliotecaProfessores")
	private List<Professor> professores;
	
	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "bibliotecaAlunos")
	private List<Aluno> alunos;
	
	public Biblioteca(long id, String nome, String nomeInstituicao, List<Livro> livros,
			List<Bibliotecario> bibliotecarios, List<Professor> professores, List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeInstituicao = nomeInstituicao;
		this.livros = livros;
		this.bibliotecarios = bibliotecarios;
		this.professores = professores;
		this.alunos = alunos;
	}

	public Biblioteca() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Bibliotecario> getBibliotecarios() {
		return bibliotecarios;
	}

	public void setBibliotecarios(List<Bibliotecario> bibliotecarios) {
		this.bibliotecarios = bibliotecarios;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
