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
import br.com.bg.biblioteca.model.Aluno;
import br.com.bg.biblioteca.model.Biblioteca;
import br.com.bg.biblioteca.model.Bibliotecario;
import br.com.bg.biblioteca.model.Devolucao;
import br.com.bg.biblioteca.model.Emprestimo;
import br.com.bg.biblioteca.model.Livro;
import br.com.bg.biblioteca.model.Professor;
import br.com.bg.biblioteca.service.AlunoService;
import br.com.bg.biblioteca.service.BibliotecarioService;
import br.com.bg.biblioteca.service.DevolucaoService;
import br.com.bg.biblioteca.service.EmprestimoService;
import br.com.bg.biblioteca.service.LivroService;
import br.com.bg.biblioteca.service.PessoaService;
import br.com.bg.biblioteca.service.ProfessorService;

@RestController
@RequestMapping(path = "/bibliotecario")
public class BibliotecarioResource {
	
	@Autowired
	private BibliotecarioService service;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Autowired
	private DevolucaoService devolucaoService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Bibliotecario bibliotecario){
		return new ResponseEntity(service.save(bibliotecario), HttpStatus.OK);
	}
	
	@PostMapping(path = "/aluno")
	public ResponseEntity<?> inserirAluno(@RequestBody Aluno aluno){
		return new ResponseEntity(alunoService.save(aluno), HttpStatus.OK);
	}
	
	@PostMapping(path = "/professor")
	public ResponseEntity<?> inserirAluno(@RequestBody Professor professor){
		return new ResponseEntity(professorService.save(professor), HttpStatus.OK);
	}
	
	@PostMapping(path = "/livro")
	public ResponseEntity<?> inserirLivro(@RequestBody Livro livro){
		return new ResponseEntity(livroService.save(livro), HttpStatus.OK);
	}
	
	@PostMapping(path = "/emprestimo")
	public ResponseEntity<?> inserirEmprestimo(@RequestBody Emprestimo emprestimo){
		return new ResponseEntity(emprestimoService.save(emprestimo), HttpStatus.OK);
	}
	
	@PostMapping(path = "/devolucao")
	public ResponseEntity<?> inserirDevolucao(@RequestBody Devolucao devolucao){
		return new ResponseEntity(devolucaoService.save(devolucao), HttpStatus.OK);
	}
	
	@GetMapping(path = "/devolucao/{id}")
	public ResponseEntity<?> recuperarDevolucaoID(@PathVariable Long id){
		return new ResponseEntity(devolucaoService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/devolucao/findAll")
	public ResponseEntity<?> recuperarDevolucaoFindAll(){
		return new ResponseEntity(devolucaoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/emprestimo/findAll")
	public ResponseEntity<?> recuperarEmprestimoFindAll(){
		return new ResponseEntity(emprestimoService.findAll(), HttpStatus.OK);
	}
	
	@PutMapping(path = "/livros")
	public ResponseEntity<?> inserirLivros(@RequestBody Devolucao devolucao){
		return new ResponseEntity(devolucaoService.save(devolucao), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findByIdAndBibliotecaId(@PathVariable Long id){
		return new ResponseEntity(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/professor/matricula/{matricula}")
	public ResponseEntity<?> buscarProfessorPelaMatricula(@PathVariable int matricula){
		return new ResponseEntity(professorService.findByLoginMatricula(matricula), HttpStatus.OK);
	}
	
	@GetMapping(path = "/aluno/nome/{nome}")
	public ResponseEntity<?> buscarAlunoPeloNome(@PathVariable String nome){
		return new ResponseEntity(alunoService.findByNome(nome), HttpStatus.OK);
	}
	
	@GetMapping(path = "/emprestimo/{id}")
	public ResponseEntity<?> buscarTodosOsEmprestimoPorIdDePessoa(@PathVariable Long id){
		return new ResponseEntity(emprestimoService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/pessoa/{id}/devolucoes")
	public ResponseEntity<?> buscarTodasAsDevolucoesPorIdDePessoa(@PathVariable Long id){
		return new ResponseEntity(devolucaoService.findByEmprestimoPessoaId(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/pessoa/{id}/devolucoes/atrasados")
	public ResponseEntity<?> buscarTodasAsDevolucoesEmAtrasoPorIdDePessoa(@PathVariable Long id){
		return new ResponseEntity(devolucaoService.buscarDevolucoesEmAtrasoPorIdDePessoa(id), HttpStatus.OK);
	}
	
	@GetMapping(path = "/pessoa/nome/{nome}")
	public ResponseEntity<?> buscarPessoaPeloNome(@PathVariable String nome) throws Exception{
		return new ResponseEntity(pessoaService.findByNome(nome), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Bibliotecario bibliotecario){
		return new ResponseEntity(service.update(bibliotecario), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return new ResponseEntity(service.delete(id), HttpStatus.OK);
	}
	
}
