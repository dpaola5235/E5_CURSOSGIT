package mx.edu.utez.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.entity.AsistenciaEntity;
import mx.edu.utez.entity.Oferta;
import mx.edu.utez.entity.Usuario;
import mx.edu.utez.repository.AsistenciaRepository;
import mx.edu.utez.repository.OfertaRepository;
import mx.edu.utez.repository.UsuarioRepository;

@Transactional
@Service
public class AsistenciaService {
	@Autowired
	private AsistenciaRepository asistenciaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired 
	private OfertaRepository ofertaRepository;
	
	
	public List<AsistenciaEntity> getAsistenciaEntitiesbyOferta(int idOferta) {
		return asistenciaRepository.findByOferta_IdOferta(idOferta);
	}
	public boolean save(AsistenciaEntity asistenciaEntity) {
		Oferta oferta = ofertaRepository.findByIdOferta(asistenciaEntity.getOferta().getIdOferta());
		asistenciaEntity.setOferta(oferta);
		Usuario alumnoUsuario = usuarioRepository.findByIdUsuario(asistenciaEntity.getEstudiante().getIdUsuario());
		asistenciaEntity.setEstudiante(alumnoUsuario);
		return asistenciaRepository.existsById(asistenciaRepository.save(asistenciaEntity).getIdAsistencia());
	}
	public List<AsistenciaEntity> saveList(List<AsistenciaEntity> listaAsistencias) {
		for (AsistenciaEntity asistenciaEntity : listaAsistencias) {
			Oferta oferta = ofertaRepository.findByIdOferta(asistenciaEntity.getOferta().getIdOferta());
			asistenciaEntity.setOferta(oferta);
			Usuario alumnoUsuario = usuarioRepository.findByIdUsuario(asistenciaEntity.getEstudiante().getIdUsuario());
			asistenciaEntity.setEstudiante(alumnoUsuario);
		}
		return asistenciaRepository.saveAll(listaAsistencias);
		
	}
	
	public List<AsistenciaEntity> getAsistenciaUsuarioOferta(int idOferta, int idUsuario){
		return asistenciaRepository.findAsistenciabyOfertaUsuario(idOferta, idUsuario);
	}
	
}
