package com.example.crudproject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuario")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/add")
	public User add(@RequestBody User usuario) {
		return userRepository.save(usuario);
	}
	
	@GetMapping("/all")
	public List<User> listarUsuario() {
		return userRepository.findAll();
	}
	
	   @PutMapping("/{id}")
	    public User atualizarUsuario(@PathVariable Long id, @RequestBody User usuarioAtualizado) {
	        return userRepository.findById(id)
	                .<User>map(usuario -> {
	                    usuario.setNome(usuarioAtualizado.getNome());
	                    usuario.setEmail(usuarioAtualizado.getEmail());
	                    usuario.setCpf(usuarioAtualizado.getCpf());
	                    usuario.setTelefone(usuarioAtualizado.getTelefone());
	                    return userRepository.save(usuario);
	                })
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
	    }
	   
	@GetMapping("/{id}")
	public User buscarUsuario(@PathVariable Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
	}
	
	  @DeleteMapping("/{id}")
	    public void deletarUsuario(@PathVariable Long id) {
		  userRepository.deleteById(id);
	    }
}
