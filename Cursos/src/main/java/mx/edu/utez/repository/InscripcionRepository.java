package mx.edu.utez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.InscripcionEntity;
@Repository
public interface InscripcionRepository extends JpaRepository<InscripcionEntity,Integer>{
	InscripcionEntity findByIdInscripcion(int id);
	
	@Query(value = "Select * from inscripcion_entity where (usuario_id_usuario = :idUsuario) and (estatus = 'liberado') ;", nativeQuery = true)
	List<InscripcionEntity> findByLiberado(@Param("idUsuario") int idUsuario);
	
	@Query(value = "SELECT * FROM inscripcion_entity where (estatus = 'en espera'); ", nativeQuery = true)
	List<InscripcionEntity> findbyPendiente();
	
	
	
}
