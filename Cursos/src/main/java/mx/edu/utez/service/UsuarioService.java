package mx.edu.utez.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mx.edu.utez.entity.Rol;
import mx.edu.utez.entity.Usuario;
import mx.edu.utez.enums.RolNombre;
import mx.edu.utez.repository.RolRepository;
import mx.edu.utez.repository.UsuarioRepository;



@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RolRepository rolRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	
	public List<Usuario> getDocentes(RolNombre rolNombre) {
		return usuarioRepository.findAllByRoles_RolNombre(rolNombre);
	}
	public Usuario getByNickname(String nickname) {
		return usuarioRepository.findByNickname(nickname);
	}
	public Usuario getByidUsuario(int id) {
		return usuarioRepository.findByIdUsuario(id);
	}

	public boolean existsByNickname(String nickname) {
		return usuarioRepository.existsByNickname(nickname);
	}

	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public boolean save(Usuario usuario, RolNombre autoridad) {
		Usuario us = usuarioRepository.findByNickname(usuario.getNickname());
		if (us == null) {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			Rol rol = rolRepository.findByRolNombre(autoridad);
			List<Rol> roles = new ArrayList();
			roles.add(rol);
			usuario.setRoles(roles);
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());

		}else {
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			return usuarioRepository.existsById(usuarioRepository.save(usuario).getIdUsuario());
		}
		
	}
	public boolean deleteUser (int id) {
		usuarioRepository.deleteById(id);
		return !usuarioRepository.existsById(id);
	}
}
