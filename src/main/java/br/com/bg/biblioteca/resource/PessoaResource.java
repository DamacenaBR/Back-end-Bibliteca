package br.com.bg.biblioteca.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bg.biblioteca.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/login/{matricula}/{senha}")
	public ResponseEntity logByMatriculaSenha(@PathVariable("matricula")int matricula,
			@PathVariable("senha")String senha) throws Exception {
		return ResponseEntity.ok(service.loginPessoa(matricula, senha));
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		return new ResponseEntity(service.findAll(), HttpStatus.OK);
	}
	
//	@GetMapping("login/{matricula}/{senha}")
//	public ResponseEntity logByMatriculaAndSenha(@PathVariable("matricula") int matricula,
//			@PathVariable("senha") String senha) throws Exception {
//		return new ResponseEntity(service.loginPessoa(matricula, senha), HttpStatus.OK);
//		
//	}
}
