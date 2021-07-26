package mx.edu.utez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.utez.entity.InscripcionEntity;
import mx.edu.utez.service.InscripcionService;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class InscripcionController {
	@Autowired
	private InscripcionService inscripcionService;
	
	@GetMapping("/inscripcion/{id}")
	public InscripcionEntity getEntity(@PathVariable("id")int id) {
		return inscripcionService.getinscInscripcionEntity(id);
		
	}
	@GetMapping("/inscripcion")
	public List<InscripcionEntity> getEntities(){
		return inscripcionService.getInscripcionEntities();
		
	}
	
	@PostMapping("/inscripcion")
	public boolean save(@RequestBody InscripcionEntity inscripcionEntity) {
		return inscripcionService.save(inscripcionEntity);
	}
	
	@PutMapping("/inscripcion")
	public boolean update(@RequestBody InscripcionEntity inscripcionEntity) {
		return inscripcionService.save(inscripcionEntity);
	}
	
	@DeleteMapping("/inscripcion/{id}")
	public boolean delete (@PathVariable("id") int id) {
		return inscripcionService.delete(id);
	}
	
	
}
