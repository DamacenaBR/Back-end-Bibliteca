package br.com.bg.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.model.Aluno;
import br.com.bg.biblioteca.model.Pessoa;
import br.com.bg.biblioteca.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa loginPessoa(int matricula, String senha)  throws Exception{
	    Optional<Pessoa> p = pessoaRepository.autenticacao(matricula, senha);
	    return p.orElseThrow(()-> new Exception("Matricula ou Senha inválidos"));
	}
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public Pessoa findByNome(String nome) throws Exception {
		Optional<Pessoa> u = pessoaRepository.findByNome(nome);
		
		return u.orElseThrow(()-> new Exception("Erro ao consultar aluno"));
	}
		
}
