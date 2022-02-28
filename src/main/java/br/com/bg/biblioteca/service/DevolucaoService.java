package br.com.bg.biblioteca.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bg.biblioteca.enums.StatusDevolucao;
import br.com.bg.biblioteca.model.Devolucao;
import br.com.bg.biblioteca.model.Emprestimo;
import br.com.bg.biblioteca.repository.DevolucaoRepository;
import br.com.bg.biblioteca.repository.EmprestimoRepository;

@Service
public class DevolucaoService {

	@Autowired
	private DevolucaoRepository repository;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	public Devolucao save(Devolucao devolucao) {
		Optional<Devolucao> devolucao2 =  Optional.ofNullable(devolucao);
		return repository.save(devolucao);
	}
	
	public Optional<Devolucao> findById(Long id) {
		Optional<Devolucao> devolucao = repository.findById(id);
		emAtraso(devolucao);
		return devolucao;
	}
	
	public List<Devolucao> findAll(){
		return repository.findAll();
	}
	
	public Devolucao temPendencia(Long pessoaId) {
		return repository.findFirst1ByEmprestimoPessoaId(pessoaId);
	}
	
	public boolean emAtraso(Optional<Devolucao> devolucao) {
		Optional<Emprestimo> emprestimo = emprestimoRepository.findById(devolucao.get().getEmprestimo().getId());
		
		LocalDate dataDevolucao = LocalDate.parse(devolucao.get().getDataDevolucao().toString());
		LocalDate dataEmprestimo = LocalDate.parse(emprestimo.get().getDataEmprestimo().toString());
		
		int diasEmAtraso = calcularDiasDeAtraso(dataEmprestimo, dataDevolucao);
		
		calcularDiasAtrasados(diasEmAtraso, devolucao);

		return false;
	}
	
	public boolean calcularDiasAtrasados(int diasEmAtraso, Optional<Devolucao> devolucao){
		
		int diasTotalEmprestimo = 3;
		
		if(diasEmAtraso > diasTotalEmprestimo) {

			int diasParaCalcularMulta = diasEmAtraso - diasTotalEmprestimo;
			
			int multa = 2;
			
			int calcularMulta = multa * diasParaCalcularMulta;
			
			devolucao.get().setStatusDevolucao(StatusDevolucao.ATRASADO);
			devolucao.get().setValorMulta(calcularMulta);
			update(devolucao.get());
			return true;
		}
		return false;
	}
	
	
	public List<Devolucao> findByEmprestimoPessoaId(Long id){
		return repository.findByEmprestimoPessoaId(id);
	}
	
	public List<Devolucao> buscarDevolucoesEmAtrasoPorIdDePessoa(Long id){
		return repository.buscarDevolucoesEmAtrasoPorIdDePessoa(id);
	}
	
	public int calcularDiasDeAtraso(LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		return (int) ChronoUnit.DAYS.between(dataEmprestimo, dataDevolucao);
	}
	
	public Devolucao update(Devolucao devolucao) {
		return repository.save(devolucao);
	}
	
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}
	
	
	
	
}
