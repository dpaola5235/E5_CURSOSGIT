package mx.edu.utez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.entity.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta,Integer>{
	Oferta findByIdOferta(int id);
	List<Oferta> findByDocente_IdDocente(int id);
}
