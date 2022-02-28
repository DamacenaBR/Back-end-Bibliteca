package br.com.bg.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bg.biblioteca.model.Bibliotecario;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
	
	List<Bibliotecario> findAllByBibliotecaId(Long bibliotecaId);
	
}
