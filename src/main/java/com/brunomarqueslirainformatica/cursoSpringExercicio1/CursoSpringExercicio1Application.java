package com.brunomarqueslirainformatica.cursoSpringExercicio1;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Categoria;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Cidade;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Cliente;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Endereco;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Estado;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.Produto;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.domain.enums.TipoCliente;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories.CategoriaRepository;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories.CidadeRepository;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories.ClienteRepository;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories.EnderecoRepository;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories.EstadoRepository;
import com.brunomarqueslirainformatica.cursoSpringExercicio1.repositories.ProdutoRepository;

@SpringBootApplication
@Component
public class CursoSpringExercicio1Application implements CommandLineRunner {

	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringExercicio1Application.class, args);
	}
	
    @Override
    public void run(String... args) throws Exception {
        logger.info("ApplicationStartupRunner run method Started !!");
        
        Categoria cat1 = new Categoria(null, "Informatica");
   		Categoria cat2 = new Categoria(null, "Escritorio");
   		
   		Produto p1 = new Produto(null, "Computador", 2000.00);
   		Produto p2 = new Produto(null, "Impressora", 800.00);
   		Produto p3 = new Produto(null, "Mouse", 80.00);
   		   		
   		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
   		cat2.getProdutos().addAll(Arrays.asList(p2));
   		
   		p1.getCategorias().addAll(Arrays.asList(cat1));
   		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
   		p3.getCategorias().addAll(Arrays.asList(cat1));
   		   		
   		Estado est1 = new Estado(null, "Minas Gerais");
   		Estado est2 = new Estado(null, "São Paulo");
   		
   		Cidade c1 = new Cidade(null, "Uberlândia", est1);
   		Cidade c2 = new Cidade(null, "São Paulo", est2);
   		Cidade c3 = new Cidade(null, "Campinas", est2);
   		
   		est1.getCidades().addAll(Arrays.asList(c1));
   		est2.getCidades().addAll(Arrays.asList(c2, c3)); 
   		
   		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "39665211245", TipoCliente.PESSOAFISICA);
   		
   		cli1.getTelefones().addAll(Arrays.asList("45142563", "969582325"));  		

   		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Perdizes", "01258020", cli1, c1);
   		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Sumaré", "91258420", cli1, c2);
   		
   		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
   		
   		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
   		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
   		estadoRepository.saveAll(Arrays.asList(est1, est2));
   		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3)); 
   		clienteRepository.saveAll(Arrays.asList(cli1));
   		enderecoRepository.saveAll(Arrays.asList(e1, e2));   		
        }
    
    }
