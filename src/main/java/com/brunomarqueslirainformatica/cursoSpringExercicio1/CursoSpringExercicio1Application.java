package com.brunomarqueslirainformatica.cursoSpringExercicio1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Categoria;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoSpringExercicio1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringExercicio1Application.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
