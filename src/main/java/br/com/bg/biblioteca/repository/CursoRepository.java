package br.com.bg.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bg.biblioteca.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
