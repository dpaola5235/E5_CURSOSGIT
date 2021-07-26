package mx.edu.utez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.entity.AsistenciaEntity;
import mx.edu.utez.service.AsistenciaService;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class AsistenciaController {
	@Autowired
	private AsistenciaService asistenciaService;
	@GetMapping("/asistencia/{idCurso}")
	public List<AsistenciaEntity> getAsistencia(@PathVariable("id") int idCurso) {
		return asistenciaService.getAsistenciaEntitiesbyOferta(idCurso);
	}
	
	@PutMapping("/asistencia")
	public boolean saveAsistencia(@RequestBody AsistenciaEntity asistenciaEntity) {
		return asistenciaService.save(asistenciaEntity);
	}
	@PostMapping("/asistencia")
	public List<AsistenciaEntity> saveListAsistencia(@RequestBody List<AsistenciaEntity> asistencias){
		return asistenciaService.saveList(asistencias);
	} 
	
}
