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

import mx.edu.utez.entity.Oferta;
import mx.edu.utez.service.OfertaService;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*",methods =
{RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT},allowedHeaders = "*")

public class OfertaController {
	@Autowired
	private OfertaService ofertaService;
	
	@GetMapping("/oferta")
	public List<Oferta> geOfertas() {
		return ofertaService.getOfertas();
	}
	@PostMapping("/oferta")
	public boolean saveOferta(@RequestBody Oferta oferta) {
		return ofertaService.saveOferta(oferta);
	}
	@PutMapping("/oferta")
	public boolean updateOferta(@RequestBody Oferta oferta) {
		return ofertaService.saveOferta(oferta);
	}
	@GetMapping("/oferta/{id}")
	public Oferta getOferta(@PathVariable("id") int id) {
		return ofertaService.getOferta(id);
	}
	
	@DeleteMapping("/oferta/{id}")
	public boolean deleteOferta(@PathVariable("id") int id) {
		return ofertaService.delete(id);
	}
	@GetMapping("/ofertaDocentes/{id}")
	public List<Oferta> getOfertaByDocente(@PathVariable("id") int id) {
		return ofertaService.findListByDocente(id);
	}
	@GetMapping("/ofertaActivo")
	public List<Oferta> getOfertaActivo(){
		return ofertaService.getOfertaActivo();
	}
	@GetMapping("/ofertaInactivo")
	public List<Oferta> getOfertaInactivo(){
		return ofertaService.getOfertaInactivo();
	}
	@GetMapping("/ofertaDocente/{idDocente}")
	public List<Oferta> getOfertaDocente(@PathVariable("idDocente") int idDocente){
		return  ofertaService.getOfertaDocenteCurso(idDocente);
	}
	@GetMapping("/ofertaDocenteInactivo/{idDocente}")
	public List<Oferta> getOfertaDocenteInactivo(@PathVariable("idDocente") int idDocente){
		return  ofertaService.getOfertaDocenteInactivo(idDocente);
	}
	@GetMapping("/ofertaDocenteActivo/{idDocente}")
	public List<Oferta> getOfertaDocenteActivo(@PathVariable("idDocente") int idDocente){
		return  ofertaService.getOfertaDocenteActivo(idDocente);
	}
	@GetMapping("/ofertaDocenteFinalizado/{idDocente}")
	public List<Oferta> getOfertaDocenteFinalizado(@PathVariable("idDocente") int idDocente){
		return  ofertaService.getOfertaDocenteFinalizado(idDocente);
	}
}
