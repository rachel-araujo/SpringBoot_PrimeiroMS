package br.com.nava.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nava.entities.UsuarioEntity;
import br.com.nava.services.UsuarioService;


@RestController
@RequestMapping("usuarios")//concatena, torna esse prefixo padrao
public class UsuarioController {
	
//	private ArrayList<UsuarioEntity> listausuario = new ArrayList<UsuarioEntity>();
//	
//	private int contador = 1;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/* @GetMapping("usuarios") */
	@GetMapping("")
	public List<UsuarioEntity> getUsuarios() {
		
		
		
		/*
		 * UsuarioEntity e = new UsuarioEntity(contador, "Rachel" + contador,
		 * "rachelaraujo17@gmail.com");
		 * 
		 * listausuario.add(e);
		 * 
		 * 
		 * contador++;
		 */
		
		return usuarioService.getAll();
	}
	
	/* @GetMapping("usuarios/{id}") */
	@GetMapping("{id}")
	public UsuarioEntity getOne(@PathVariable Integer id) {
//		System.out.println(id);
//		for (int i = 0; i < listausuario.size(); i++) {
//			if (listausuario.get(i).getId() == id) {
//					return listausuario.get(i);
//			}
//		 
//		}
//		
//		return null;
		return usuarioService.getOne(id);

	}
	
	/* @PostMapping("usuarios") */
	@PostMapping("")
	public UsuarioEntity save(@RequestBody UsuarioEntity usuario) {
		
//		System.out.println(usuario);
//		
//		usuario.setId(contador);
//		listausuario.add(usuario);
//		contador++;
//		
//		return usuario;
		return usuarioService.save(usuario);
		
		
	}
	
	/* @PatchMapping("usuarios/{id}") */
	@PatchMapping("{id}")
	public UsuarioEntity update(@PathVariable Integer id, @RequestBody UsuarioEntity usuario) {
//		System.out.println(id);
//		System.out.println(usuario);
//		
//		
//		for (int i = 0; i < listausuario.size(); i++) {
//			
//			if (listausuario.get(i).getId() == id) {
//				listausuario.get(i).setNome(usuario.getNome());
//				listausuario.get(i).setEmail(usuario.getEmail());
//				
//				return listausuario.get(i);
//			}
//		}
//		
//		return null;
		return usuarioService.update(id, usuario);
		
	}
	
	/* @DeleteMapping("usuarios/{id}") */
	@DeleteMapping("{id}")
	public void delete (@PathVariable Integer id) {
//		for (int i = 0; i < listausuario.size(); i++) {
//			if (listausuario.get(i).getId() == id) {
//				listausuario.remove(i);
//			}
//		}
		
		usuarioService.delete(id);
		
	}
}
