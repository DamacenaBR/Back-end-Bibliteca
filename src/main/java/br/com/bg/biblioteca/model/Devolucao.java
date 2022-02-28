package br.com.bg.biblioteca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.bg.biblioteca.enums.StatusDevolucao;

@Entity
public class Devolucao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Emprestimo emprestimo;
	
	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;
	
	private float valorMulta;
	
	@Enumerated(EnumType.ORDINAL)
	private StatusDevolucao statusDevolucao;

	public Devolucao(Long id, Emprestimo emprestimo, Date dataDevolucao, float valorMulta, StatusDevolucao statusDevolucao) {
		super();
		this.id = id;
		this.emprestimo = emprestimo;
		this.dataDevolucao = dataDevolucao;
		this.valorMulta = valorMulta;
		this.statusDevolucao = statusDevolucao;
	}
	
	public Devolucao() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public float getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(float valorMulta) {
		this.valorMulta = valorMulta;
	}

	public StatusDevolucao getStatusDevolucao() {
		return statusDevolucao;
	}

	public void setStatusDevolucao(StatusDevolucao statusDevolucao) {
		this.statusDevolucao = statusDevolucao;
	}
}
