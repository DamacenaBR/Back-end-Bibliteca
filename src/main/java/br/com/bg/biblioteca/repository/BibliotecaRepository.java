package br.com.bg.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bg.biblioteca.model.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long>{

}
