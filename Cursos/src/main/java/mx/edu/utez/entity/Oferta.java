package mx.edu.utez.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOferta;
	private double costo;
	private int minimoParticipantes;
	private int maximoParticipantes;
	private Date fechaPeriodoInscripcion;
	private Date fechaInicio;
	private Date fechaFin;
	@ManyToOne
	private List<CursoEntity> cursos;
	@ManyToOne
	private List<ModalidadEntity> modalidades;
	@ManyToOne
	private List<ClasificacionEntity> clasificaciones;
	@ManyToOne
	private List<DivisionEntity> divisiones;
	@ManyToMany
	private List<Usuario> usuariosInscritos;
	@OneToMany 
	private List<Usuario> docentes;
	
	
}
