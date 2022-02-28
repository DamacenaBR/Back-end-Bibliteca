package br.com.bg.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bg.biblioteca.model.Aluno;
import br.com.bg.biblioteca.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	@Query("select p from Pessoa p where p.login.matricula=:matricula and p.login.senha=:senha")
	public Optional<Pessoa> autenticacao(@Param("matricula") int matricula, @Param("senha") String senha);

	
	public Optional<Pessoa> findByNome(String nome);
}
