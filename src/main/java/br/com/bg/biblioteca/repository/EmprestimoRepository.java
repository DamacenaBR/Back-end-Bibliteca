package br.com.bg.biblioteca.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bg.biblioteca.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
	List<Emprestimo> findLivroByPessoaId(Long id);
	
	/*
	 * Contar exemplares de um emprestimo
	 * */
	@Query(value = "SELECT COUNT(livro.id) FROM emprestimo_livro JOIN emprestimo ON emprestimo.id = emprestimo_livro.emprestimo_id JOIN livro ON livro.id = emprestimo_livro.livro_id WHERE emprestimo_livro.emprestimo_id = ?1 AND livro.id = ?2", nativeQuery = true)
	long recuperarQuantidadeDeExemplares(Long emprestimoId, Long livroId);
	
	@Query(value = "SELECT COUNT(livro.id) FROM emprestimo_livro JOIN emprestimo ON emprestimo.id = emprestimo_livro.emprestimo_id JOIN livro ON livro.id = emprestimo_livro.livro_id WHERE emprestimo_livro.emprestimo_id = ?1", nativeQuery = true)
	long recuperarQuantidadeDeLivrosNoEmprestimo(Long emprestimoId);
	
	List<Emprestimo> findByPessoaId(Long pessoaId);
	
	@Query(value = "select e from Emprestimo e join e.pessoa u where u.nome= :nome")
	public List<Emprestimo> findByEmprestimoAluno(String nome);
	
	@Query(value = "SELECT d.dataDevolucao FROM Devolucao as d WHERE d.emprestimo.id = ?1")
	public Date verificarDevolucao(Long id);
	
}
