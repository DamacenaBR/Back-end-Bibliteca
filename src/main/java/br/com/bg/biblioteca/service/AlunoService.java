package br.com.bg.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Aluno;
import br.com.bg.biblioteca.model.Bibliotecario;
import br.com.bg.biblioteca.model.Professor;
import br.com.bg.biblioteca.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	public Aluno save(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public Optional<Aluno> findById(Long id) {
		return repository.findById(id);
	}
	
	public Aluno findByNome(String nome) {
		return repository.findByNomeContaining(nome);
	}
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno update(Aluno aluno) {
		return repository.save(aluno);
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}
}
