package mx.edu.utez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.ModalidadEntity;


@Repository
public interface ModalidadRepository extends JpaRepository<ModalidadEntity,Integer>{
	ModalidadEntity findByIdModalidad(int id);
}
