package mx.edu.utez.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.entity.ClasificacionEntity;
import mx.edu.utez.entity.CursoEntity;
import mx.edu.utez.entity.DivisionEntity;
import mx.edu.utez.entity.ModalidadEntity;
import mx.edu.utez.entity.Oferta;
import mx.edu.utez.entity.Usuario;
import mx.edu.utez.repository.ClasificacionRepository;
import mx.edu.utez.repository.CursoRepository;
import mx.edu.utez.repository.DivisionRepository;
import mx.edu.utez.repository.ModalidadRepository;
import mx.edu.utez.repository.OfertaRepository;
import mx.edu.utez.repository.UsuarioRepository;

@Service
@Transactional
public class OfertaService {
	@Autowired
	private OfertaRepository ofertaRepository;
	
	@Autowired 
	private CursoRepository cursoRepository;
	@Autowired
	private ModalidadRepository modalidadRepository;
	@Autowired
	private ClasificacionRepository clasificacionRepository;
	@Autowired
	private DivisionRepository divisionRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Oferta> getOfertas() {
		return ofertaRepository.findAll();
	}
	
	public Oferta getOferta(int id) {
		return ofertaRepository.findByIdOferta(id);
	}
	
	public boolean saveOferta(Oferta oferta) {
		List<CursoEntity> cursos = new ArrayList<CursoEntity>();
		List<ModalidadEntity> modalidades = new ArrayList<ModalidadEntity>();
		List<DivisionEntity> divisiones = new ArrayList<DivisionEntity>();
		List<ClasificacionEntity> clasificaciones = new ArrayList<ClasificacionEntity>();
		List<Usuario> profes = new ArrayList<Usuario>();
		
		for (CursoEntity cursoAux : oferta.getCursos()) {
			cursos.add(cursoRepository.findByIdCurso(cursoAux.getIdCurso()));
		}
		//Se establecen los valores completos de la base de datos de la tabla "CURSOS"
		oferta.setCursos(cursos);
		
		for (ModalidadEntity modalidadAux : oferta.getModalidades()) {
			modalidades.add(modalidadRepository.findByIdModalidad(modalidadAux.getIdModalidad()));
		}
		//Se establecen los valores completos de la base de datos de la tabla "MODALIDADES"
		oferta.setModalidades(modalidades);
		
		for (DivisionEntity divisionAux : oferta.getDivisiones()) {
			divisiones.add(divisionRepository.findByIdDivision(divisionAux.getIdDivision()));
		}
		//Se establecen los valores completos de la base de datos de la tabla "divisiones"
		oferta.setDivisiones(divisiones);
		
		for (ClasificacionEntity clasificacionAux : oferta.getClasificaciones()) {
			clasificaciones.add(clasificacionRepository.findByIdClasificacion(clasificacionAux.getIdClasificacion()));
		}
		//Se establecen los valores completos de la base de datos de la tabla "clasificaciones"
		oferta.setClasificaciones(clasificaciones);
		
		for (Usuario usuarioAux : oferta.getDocentes()) {
			profes.add(usuarioRepository.findByIdUsuario(usuarioAux.getIdUsuario()));
		}
		//Se establecen los valores completos de la base de datos de la tabla "divisiones"
		oferta.setDocentes(profes);
		
		
		return ofertaRepository.existsById(ofertaRepository.save(oferta).getIdOferta());
	}
	
	public boolean delete(int id) {
		ofertaRepository.deleteById(id);
		return !ofertaRepository.existsById(id);
	}
}
