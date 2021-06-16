package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;





@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioModelTests {
	
	public Usuario usuario;
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@BeforeEach
	public void start() {
		usuario = new Usuario("Juci Leal", "Jucil", "teste123456");
	}
	
	@Disabled //irá pular esse test, esse método não será executado por que esta disabled
	@Test
	void testValidarAtributor() {
		
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario); //esse método realiza as validações das anotações do tipo @NotBlank e @NotNull
		System.out.println(violacao.toString());
		assertTrue(violacao.isEmpty()); //assertTrue é o mesmo que System.out.println para o JUnit, assertTrue é o mesmo que imprima 
		//assertTrue = estou esperando tal coisa
	}

	
	@Test
	void testValidarAtributosBlank() {
		Usuario usuarioErro = new Usuario(); //usando o construtor vazio da model Usuario para testar os @NotBlank nos atributos
		usuarioErro.setUsuario("Juci Leal");
		usuarioErro.setNome("Jucil");
		
		//usuarioErro recebe somente o nome, o usuario mas não o atributo senha
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioErro);
		//o validator checa todos os atributos da model Usuario através do objeto usuarioErro e como a senha esta faltando na instancia
		//desse objeto usuarioErro o validator violacao pega um erro (senha esta blank)
		System.out.println(violacao.toString()); //printando na tela a messagem passada no @NotBlank em senha
		assertTrue(violacao.isEmpty()); //mostra o failure = 1 porque testa se violacao esta vazio e como é falso o failure retorna 1
	}
}
