package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); 
	/*método findAll busca pelo Titulo (o parâmetro/entidade titulo em minúscula criado por mim 
	 * na classe postagem, Containing é o mesmo que o LIKE do sql, IgnoreCase é para não ser case
	 * sensitive, busca todo mundo pelo título trazendo o que tem dentro dele sem levar em consideração
	 * maiúsculas e minúsculas. */

	
}
