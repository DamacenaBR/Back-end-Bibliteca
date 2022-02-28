package br.com.bg.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bg.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	Livro findByIsbn(String isbn);
	
	List<Livro> findAllByArea(Enum<?> area);
	
	Livro findByNomeContaining(String nome);
	
	@Query("SELECT quantidade FROM Livro WHERE id = ?1")
	int findQuantidadeById(Long id);
}
