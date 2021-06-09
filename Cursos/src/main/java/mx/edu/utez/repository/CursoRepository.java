package mx.edu.utez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.CursoEntity;
@Repository
public interface CursoRepository extends JpaRepository<CursoEntity,Integer> {
	CursoEntity findByIdCurso (int id);
}
