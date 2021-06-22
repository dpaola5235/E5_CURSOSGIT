package mx.edu.utez.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.entity.Usuario;
import mx.edu.utez.enums.RolNombre;
import mx.edu.utez.service.UsuarioService;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class DocenteController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/docente/getAll")
	public List<Usuario> getUsersDocentes() {
		return usuarioService.getDocentes(RolNombre.ROLE_DOCENTE);
	}
	@GetMapping("/docente/getOne/{id}")
	public Usuario getUserDocente(@PathVariable("id") int id) {
		return usuarioService.getByidUsuario(id);
	}
	@PostMapping("/docente/save")
	public ResponseEntity<?> saveUser(@Valid @RequestBody Usuario user){		
		return ResponseEntity.ok(usuarioService.save(user, RolNombre.ROLE_DOCENTE));
	}
	@PutMapping("/docente/update")
	public ResponseEntity<?> updateUser(@Valid @RequestBody Usuario user){		
		return ResponseEntity.ok(usuarioService.save(user, RolNombre.ROLE_DOCENTE));
	}
	@DeleteMapping("/docente/delete/{id}")
	public boolean deleteUser(@PathVariable("id") int id) {
		return usuarioService.deleteUser(id);
	}

}
