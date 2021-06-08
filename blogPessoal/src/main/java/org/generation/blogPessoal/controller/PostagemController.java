package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired //interface de gestão de dependencia do Spring
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
		/*findAll envia como recurso (continuar a escrever a explicação*/
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	
	@PostMapping //para fazer uma nova postagem, por isso o id não é passado (é autoincrement)
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		//return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
		return ResponseEntity.status(201).body(repository.save(postagem));
	}
	@PutMapping //para fazer uma atualização, por isso deve passar o id já existente
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		//return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}") //passando parâmetro por interpolação/template literal, pelas chaves {}
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}


}
