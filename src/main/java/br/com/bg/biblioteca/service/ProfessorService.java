package br.com.bg.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Professor;
import br.com.bg.biblioteca.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;
	
	public Professor save(Professor professor) {
		return repository.save(professor);
	}
	
	public Optional<Professor> findById(Long id) {
		return repository.findById(id);
	}
	
	public Professor findByLoginMatricula(int matricula) {
		return repository.findByLoginMatricula(matricula);
	}
	
	public List<Professor> findAll(){
		return repository.findAll();
	}
	
	public Professor update(Professor professor) {
		return repository.save(professor);
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}
}
