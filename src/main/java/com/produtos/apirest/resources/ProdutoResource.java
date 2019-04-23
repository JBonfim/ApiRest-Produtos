package com.produtos.apirest.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository pRepository;
	
	
	@GetMapping("/produtos")
	@ApiOperation(value="retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return pRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="retorna um produto de acordo com o id")
	public Produto getProduto(@PathVariable(value="id") long id){
		return pRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="cadastra o produto")
	public Produto save(@RequestBody Produto produto){
		return pRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value="apaga o produto")
	public void delete(@RequestBody Produto produto){
		pRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="atualiza um determinado produto")
	public Produto update(@RequestBody Produto produto){
		return pRepository.save(produto);
	}
}

