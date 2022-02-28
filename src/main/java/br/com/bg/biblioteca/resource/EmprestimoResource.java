package br.com.bg.biblioteca.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bg.biblioteca.model.Bibliotecario;
import br.com.bg.biblioteca.model.Emprestimo;
import br.com.bg.biblioteca.service.EmprestimoService;
import br.com.bg.biblioteca.service.LivroService;

@RestController
@RequestMapping(path = "/emprestimo")
public class EmprestimoResource {

	@Autowired
	private EmprestimoService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Emprestimo emprestimo){
		return service.save(emprestimo)
				? new ResponseEntity(!service.save(emprestimo), HttpStatus.OK) 
						:  new ResponseEntity("{\"mensagem\":\"Ocorreu um erro ao cadastrar o emprestimo!\"}", HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return new ResponseEntity(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/usuario/{id}")
	public ResponseEntity<?> findAllLivrosByPessoaId(@PathVariable Long id){
		return new ResponseEntity(service.findLivroByPessoaId(id), HttpStatus.OK);
	} 
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Emprestimo emprestimo){
		return service.save(emprestimo)
				? new ResponseEntity(service.save(emprestimo), HttpStatus.OK) 
						:  new ResponseEntity("{\"mensagem\":\"Ocorreu um erro ao atualizar o emprestimo!\"}", HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity(service.delete(id), HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<?> findByEmprestimoAluno(@PathVariable String nome) throws Exception{
		return new ResponseEntity(service.findByEmprestimoAluno(nome), HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/verificar/{id}")
	public ResponseEntity<?> verificarDevolucao(@PathVariable Long id) throws Exception{
		System.out.println(id);
		return new ResponseEntity(service.verificarDevolucao(id), HttpStatus.OK);
		
	}
}
