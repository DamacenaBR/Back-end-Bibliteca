package br.com.bg.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Biblioteca;
import br.com.bg.biblioteca.model.Curso;
import br.com.bg.biblioteca.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	public Curso save(Curso curso) {
		return repository.save(curso);
	}
	
	public Optional<Curso> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<Curso> findAll(){
		return repository.findAll();
	}
	
	public Curso update(Curso curso) {
		return repository.save(curso);
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

}
