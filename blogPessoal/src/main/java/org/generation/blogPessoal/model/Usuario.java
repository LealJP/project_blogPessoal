package org.generation.blogPessoal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	//para os campos abaixos estou setando tamanho minimo por tanto não precisa o @NotNull
	@NotBlank(message = "campo nome não pode ser vazio/branco")
	@Size(min = 2, max = 100, message="tamanho entre 2 e 100")
	private String nome;
	

	@NotBlank(message = "campo usuario não pode ser vazio/branco")
	@Size(min = 5, max = 100, message="tamanho entre 5 e 100")
	private String usuario;
	
	@NotBlank(message = "campo senha não pode ser vazio/branco")
	@Size(min = 5, max = 100, message="tamanho entre 5 e 100")
	private String senha;
	

	public Usuario() {}
	
	

	public Usuario(String nome, String usuario, String senha) {
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


}
