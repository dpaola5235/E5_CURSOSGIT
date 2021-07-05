package mx.edu.utez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.DivisionEntity;

@Repository
public interface DivisionRepository extends JpaRepository<DivisionEntity,Integer> {
	DivisionEntity findByIdDivision(int id);
}
