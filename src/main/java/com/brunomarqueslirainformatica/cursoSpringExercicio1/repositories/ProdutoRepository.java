package com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{


}