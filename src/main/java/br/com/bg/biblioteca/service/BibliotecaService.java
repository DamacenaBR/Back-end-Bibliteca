package br.com.bg.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Biblioteca;
import br.com.bg.biblioteca.repository.BibliotecaRepository;

@Service
public class BibliotecaService {

	@Autowired
	private BibliotecaRepository repository;
	
	public Biblioteca save(Biblioteca biblioteca) {
		return repository.save(biblioteca);
	}
	
	public Optional<Biblioteca> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<Biblioteca> findAll(){
		return repository.findAll();
	}
	
	public Biblioteca update(Biblioteca biblioteca) {
		return repository.save(biblioteca);
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}
}
