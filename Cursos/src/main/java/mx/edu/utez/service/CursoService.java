package mx.edu.utez.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.entity.CursoEntity;
import mx.edu.utez.repository.CursoRepository;

@Service
@Transactional
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<CursoEntity> getCursoEntities() {
		return cursoRepository.findAll();
	}
	
	public CursoEntity getCursoEntity(int id) {
		return cursoRepository.findByIdCurso(id);
	}
	
	public boolean saveCurso(CursoEntity cursoEntity) {
		return cursoRepository.existsById(cursoRepository.save(cursoEntity).getIdCurso());
	}
	
	public boolean deleteCurso(int id) {
		cursoRepository.deleteById(id);
		return !cursoRepository.existsById(id);
	}
}
