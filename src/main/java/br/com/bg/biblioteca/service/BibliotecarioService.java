package br.com.bg.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Bibliotecario;
import br.com.bg.biblioteca.repository.BibliotecarioRepository;

@Service
public class BibliotecarioService {
	
	@Autowired
	private BibliotecarioRepository repository;
	
	public Bibliotecario save(Bibliotecario bibliotecario) {
		return repository.save(bibliotecario);
	}
	
	public Optional<Bibliotecario> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<Bibliotecario> findAll(){
		return repository.findAll();
	}
	
	public List<Bibliotecario> findAllByBibliotecaId(Long bibliotecaId){
		return repository.findAllByBibliotecaId(bibliotecaId);
	}
	
	public Bibliotecario update(Bibliotecario bibliotecario) {
		return repository.save(bibliotecario);
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

}
