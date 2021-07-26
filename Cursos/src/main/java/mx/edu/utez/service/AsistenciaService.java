package mx.edu.utez.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.entity.AsistenciaEntity;
import mx.edu.utez.repository.AsistenciaRepository;

@Transactional
@Service
public class AsistenciaService {
	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	public List<AsistenciaEntity> getAsistenciaEntitiesbyOferta(int idOferta) {
		return asistenciaRepository.findByOferta_IdOferta(idOferta);
	}
	public boolean save(AsistenciaEntity asistenciaEntity) {
		return asistenciaRepository.existsById(asistenciaRepository.save(asistenciaEntity).getIdAsistencia());
	}
	public List<AsistenciaEntity> saveList(List<AsistenciaEntity> listaAsistencias) {
		return asistenciaRepository.saveAll(listaAsistencias);
		
	}
}
