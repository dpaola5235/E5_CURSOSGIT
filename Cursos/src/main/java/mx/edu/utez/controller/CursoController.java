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

import mx.edu.utez.entity.CursoEntity;
import mx.edu.utez.service.CursoService;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/curso/getAll")
	public List<CursoEntity> getCursoEntities() {
		return cursoService.getCursoEntities();
	}
	@PostMapping("/curso/save")
	public boolean saveCurso(@RequestBody CursoEntity cursoEntity) {
		return cursoService.saveCurso(cursoEntity);
	}
	
	@GetMapping("/curso/getOne/{id}")
	public CursoEntity getCursoEntity(@PathVariable("id") int id) {
		return cursoService.getCursoEntity(id);
	}
	
	@DeleteMapping("/curso/delete/{id}")
	public boolean deleteCurso(@PathVariable("id") int id) {
		return cursoService.deleteCurso(id);
	}
	
	@PutMapping("/curso/update")
	public boolean updateCurso(@RequestBody CursoEntity cursoEntity) {
		return cursoService.saveCurso(cursoEntity);
	}
	
}
