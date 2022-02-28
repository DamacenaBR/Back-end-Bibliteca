package br.com.bg.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bg.biblioteca.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	Aluno findByNomeContaining(String nome);
	
}
