package mx.edu.utez.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.entity.InscripcionEntity;
import mx.edu.utez.entity.Oferta;
import mx.edu.utez.entity.Usuario;
import mx.edu.utez.repository.InscripcionRepository;
import mx.edu.utez.repository.OfertaRepository;
import mx.edu.utez.repository.UsuarioRepository;

@Service
@Transactional
public class InscripcionService {
	@Autowired
	private InscripcionRepository inscripcionRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private OfertaRepository ofertaRepository;
	public InscripcionEntity getinscInscripcionEntity(int id) {
		return inscripcionRepository.findByIdInscripcion(id);
		
	}
	
	public List<InscripcionEntity> getInscripcionEntities() {
		return inscripcionRepository.findAll();
	}
	
	public boolean save(InscripcionEntity inscripcionEntity) {
		Usuario userAux = usuarioRepository.findByIdUsuario(inscripcionEntity.getUsuario().getIdUsuario());
		Oferta ofertaAux = ofertaRepository.findByIdOferta(inscripcionEntity.getOferta().getIdOferta());
		inscripcionEntity.setUsuario(userAux);
		inscripcionEntity.setOferta(ofertaAux);
		return inscripcionRepository.existsById(inscripcionRepository.save(inscripcionEntity).getIdInscripcion());
	}
	
	public boolean delete(int id) {
		inscripcionRepository.deleteById(id);
		return !inscripcionRepository.existsById(id);
	}
}
