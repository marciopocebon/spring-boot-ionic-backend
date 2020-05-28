package com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{


}