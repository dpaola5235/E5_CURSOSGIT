package mx.edu.utez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
