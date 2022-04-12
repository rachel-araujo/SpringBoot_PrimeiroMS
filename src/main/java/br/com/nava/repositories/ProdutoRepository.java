package br.com.nava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nava.entities.ProdutoEntity;
import br.com.nava.entities.ProfessorEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
	

}
