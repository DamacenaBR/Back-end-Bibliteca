package br.com.bg.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Livro;
import br.com.bg.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public Livro save(Livro livro) {
		return repository.save(livro);
	}
	
	public Optional<Livro> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<Livro> findAll(){
		return repository.findAll();
	}
	
	public Livro update(Livro livro) {
		return repository.save(livro);
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}
	
	public Livro findByIsbn(String isbn) {
		return repository.findByIsbn(isbn);
	}
	
	public List<Livro> findAllByArea(Enum<?> area){
		return repository.findAllByArea(area);
	}
	
	public Livro findByNome(String nome) {
		return repository.findByNomeContaining(nome);
	}
	
	public int getQuantity(Long id) {
		return repository.findQuantidadeById(id);
	}
}
