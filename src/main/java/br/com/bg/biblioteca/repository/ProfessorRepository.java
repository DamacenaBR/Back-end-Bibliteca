package br.com.bg.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bg.biblioteca.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	Professor findByLoginMatricula(int matricula);
	
}
