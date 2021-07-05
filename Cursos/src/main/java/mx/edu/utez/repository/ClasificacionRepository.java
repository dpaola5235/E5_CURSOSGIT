package mx.edu.utez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.ClasificacionEntity;

@Repository
public interface ClasificacionRepository extends JpaRepository<ClasificacionEntity, Integer> {
	ClasificacionEntity findByIdClasificacion(int id);
}
