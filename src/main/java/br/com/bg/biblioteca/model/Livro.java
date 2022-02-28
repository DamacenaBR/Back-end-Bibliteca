package br.com.bg.biblioteca.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.bg.biblioteca.enums.AreaLivro;

@Entity
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	
	@Column(unique = true)
	private String isbn;
	
	@Enumerated(EnumType.ORDINAL)
	private AreaLivro area;
	
	private int quantidade;
	
	@OneToOne
	@JsonBackReference(value = "bibliotecaLivros")
	private Biblioteca biblioteca;
	
	@ManyToMany(mappedBy = "livros")
	@JsonBackReference
	private List<Emprestimo> emprestimos;
	
	public Livro(long id, String nome, String isbn, AreaLivro area, int quantidade, Biblioteca biblioteca,
			List<Emprestimo> emprestimos) {
		super();
		this.id = id;
		this.nome = nome;
		this.isbn = isbn;
		this.area = area;
		this.quantidade = quantidade;
		this.biblioteca = biblioteca;
		this.emprestimos = emprestimos;
	}

	public Livro() {
		
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public AreaLivro getArea() {
		return area;
	}

	public void setArea(AreaLivro area) {
		this.area = area;
	}
	
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
