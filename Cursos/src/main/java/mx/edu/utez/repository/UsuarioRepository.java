package mx.edu.utez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.Usuario;
import mx.edu.utez.enums.RolNombre;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNickname(String nickname);
	Usuario findByIdUsuario(int idUsuario);
	boolean existsByNickname(String nickname);
	boolean existsByEmail(String email);
	List<Usuario> findAllByRoles_RolNombre(RolNombre rolNombre);
}
