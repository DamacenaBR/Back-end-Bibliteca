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

import br.com.bg.biblioteca.model.Curso;
import br.com.bg.biblioteca.model.Devolucao;
import br.com.bg.biblioteca.service.CursoService;
import br.com.bg.biblioteca.service.DevolucaoService;

@RestController
@RequestMapping(path = "/devolucao")
public class DevolucaoResource {
	
	@Autowired
	private DevolucaoService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Devolucao devolucao){
		return new ResponseEntity(service.save(devolucao), HttpStatus.OK);
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
	public ResponseEntity<?> update(@RequestBody Devolucao devolucao){
		return new ResponseEntity(service.update(devolucao), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity(service.delete(id), HttpStatus.OK);
	}

}
