package br.com.bg.biblioteca.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Emprestimo;
import br.com.bg.biblioteca.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;
	
	@Autowired
	private DevolucaoService devolucaoService;
	
	
	
	public List<Emprestimo> findByEmprestimoAluno(String nome) throws Exception {
		List<Emprestimo> emprestTemp = new ArrayList<>();
		List<Emprestimo> m = repository.findByEmprestimoAluno(nome);
		for(Emprestimo e: m) {
			if(verificarDevolucao(e.getId())) {
				emprestTemp.add(e);
			}
		}
		return emprestTemp;
	}
	
	public boolean verificarDevolucao(Long idEmprestimo) {
	return repository.verificarDevolucao(idEmprestimo) == null;
}
	
	public boolean save(Emprestimo emprestimo) {
		if(temPendencia(emprestimo.getPessoa().getId()) 
				|| existeExemplar(emprestimo)) {
			return false;
		}
		repository.save(emprestimo);
		return true;
	}
	
	public boolean temPendencia(Long pessoaId) {
		if(devolucaoService.temPendencia(pessoaId) != null) {
			return true;
		}
		return false;
	}
	
	/*
	 * Existe um erro aqui, não consegui resolver.
	 * Problema: Varre toda lista de livros se tiver algum que já exista ele não atualiza
	 * */
	
	public boolean existeExemplar(Emprestimo emprestimo) {
		for(int i = 0; i < emprestimo.getLivros().size(); i++) {
				if(repository.recuperarQuantidadeDeExemplares(emprestimo.getId(), 
						emprestimo.getLivros().get(i).getId()) == 1) {
					System.out.println("Já existe um exemplar");
					return true;
				}
		}
		return false;
	}
	
	public long quantidadeLivros(Long emprestimoId) {
		return repository.recuperarQuantidadeDeLivrosNoEmprestimo(emprestimoId);
	}
	
	public Optional<Emprestimo> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<Emprestimo> findAllByPessoaId(Long id){
		return repository.findByPessoaId(id);
	}
	
	public List<Emprestimo> findAll(){
		return repository.findAll();
	}
	
	public Emprestimo update(Emprestimo emprestimo) {
		if(quantidadeLivros(emprestimo.getId()) > 3) {
			System.out.println("Não pode pegar mais livros");
			return null;
		}else {
			return repository.save(emprestimo);
		}
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}
	
	public List<Emprestimo> findLivroByPessoaId(Long id) {
		return repository.findLivroByPessoaId(id);
	}
	
}
