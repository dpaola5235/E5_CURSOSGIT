package mx.edu.utez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.InscripcionEntity;
@Repository
public interface InscripcionRepository extends JpaRepository<InscripcionEntity,Integer>{
	InscripcionEntity findByIdInscripcion(int id);
}
