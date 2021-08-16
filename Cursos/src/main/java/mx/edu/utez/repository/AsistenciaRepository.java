package mx.edu.utez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.AsistenciaEntity;

@Repository
public interface AsistenciaRepository extends JpaRepository<AsistenciaEntity, Integer> {
	List<AsistenciaEntity> findByOferta_IdOferta(int id);
	
	@Query(value = "SELECT * FROM asistencia_entity where (oferta_id_oferta = :idOferta) and (estudiante_id_usuario = :idUsuario);", nativeQuery = true)
	List<AsistenciaEntity> findAsistenciabyOfertaUsuario(@Param("idOferta") int idOferta, @Param("idUsuario") int idUsuario);
}
