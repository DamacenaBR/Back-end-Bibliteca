package br.com.bg.biblioteca.resource;

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

import br.com.bg.biblioteca.model.Aluno;
import br.com.bg.biblioteca.service.AlunoService;

@RestController
@RequestMapping(path = "/aluno")
public class AlunoResource {

	@Autowired
	private AlunoService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Aluno aluno){
		return new ResponseEntity(service.save(aluno), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return new ResponseEntity(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Aluno aluno){
		return new ResponseEntity(service.update(aluno), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity(service.delete(id), HttpStatus.OK);
	}
	
}
