package br.com.nava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.entities.ProdutoEntity;
import br.com.nava.services.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<ProdutoEntity> getAll(){
		return this.produtoService.getAll();
	}
	
	@GetMapping("{id}")
	public ProdutoEntity getOne(@PathVariable int id) {
		return produtoService.getOne(id);
	}
	
	@PostMapping
	public ProdutoEntity save(@RequestBody ProdutoEntity produto) {
		return produtoService.save(produto);
	}
	
	@PatchMapping("{id}")
	public ProdutoEntity update(@PathVariable int id, 
			@RequestBody ProdutoEntity produto) {
		return produtoService.update(id, produto);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		produtoService.delete(id);
	}
}