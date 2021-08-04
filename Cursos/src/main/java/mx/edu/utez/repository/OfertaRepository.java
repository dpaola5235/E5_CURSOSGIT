package mx.edu.utez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta,Integer>{
	Oferta findByIdOferta(int id);
	List<Oferta> findByDocente_IdUsuario(int id);
	
	@Query(value = "SELECT * FROM oferta where (estado = 'activo'); ", nativeQuery = true)
	List<Oferta> findbyActivo();
	
	@Query(value = "SELECT * FROM oferta where (estado = 'inactivo'); ", nativeQuery = true)
	List<Oferta> findbyInactivo();
	
	@Query(value = "SELECT * FROM oferta where (estado = 'en curso') and (docente_id_usuario = :idDocente); ", nativeQuery = true)
	List<Oferta> findbyDocenteCurso(@Param("idDocente") int idDocente);
	
	@Query(value = "SELECT * FROM oferta where (estado = 'inactivo') and (docente_id_usuario = :idDocente); ", nativeQuery = true)
	List<Oferta> findbyDocenteInactivo(@Param("idDocente") int idDocente);
	
	@Query(value = "SELECT * FROM oferta where (estado = 'activo') and (docente_id_usuario = :idDocente); ", nativeQuery = true)
	List<Oferta> findbyDocenteActivo(@Param("idDocente") int idDocente);
	
	@Query(value = "SELECT * FROM oferta where (estado = 'finalizado') and (docente_id_usuario = :idDocente); ", nativeQuery = true)
	List<Oferta> findbyDocenteFinalizado(@Param("idDocente") int idDocente);
}
