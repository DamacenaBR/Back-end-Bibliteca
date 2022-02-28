package br.com.bg.biblioteca.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bg.biblioteca.model.Devolucao;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {
	
	Devolucao findFirst1ByEmprestimoPessoaId(Long pessoaId);

	List<Devolucao> findByEmprestimoPessoaId(Long pessoaId);
	
	@Query(nativeQuery = true, value = "SELECT * FROM devolucao JOIN emprestimo ON emprestimo.id = devolucao.emprestimo_id JOIN pessoa ON emprestimo.pessoa_id = pessoa.id WHERE pessoa.id = ?1 AND devolucao.status_devolucao = 1")
	List<Devolucao> buscarDevolucoesEmAtrasoPorIdDePessoa(Long pessoaId);
	
}
