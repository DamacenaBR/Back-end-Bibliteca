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

import br.com.bg.biblioteca.enums.AreaLivro;
import br.com.bg.biblioteca.model.Livro;
import br.com.bg.biblioteca.service.LivroService;

@RestController
@RequestMapping(path = "/livro")
public class LivroResource {

	@Autowired
	private LivroService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Livro livro){
		return new ResponseEntity(service.save(livro), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return new ResponseEntity(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/isbn/{isbn}")
	public ResponseEntity<?> findLivroByIsbn(@PathVariable String isbn){
		return new ResponseEntity(service.findByIsbn(isbn), HttpStatus.OK);
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<?> findAllLivroByNome(@PathVariable String nome){
		return new ResponseEntity(service.findByNome(nome), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}/quantidade")
	public ResponseEntity<?> getQuantity(@PathVariable Long id){
		return new ResponseEntity(service.getQuantity(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/area/{area}")
	public ResponseEntity<?> findAllLivroByArea(@PathVariable Integer area){
		Enum codigo = AreaLivro.toEnum(area);
		return new ResponseEntity(service.findAllByArea(codigo), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Livro livro){
		return new ResponseEntity(service.update(livro), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity(service.delete(id), HttpStatus.OK);
	}
}
