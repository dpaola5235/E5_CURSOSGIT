package mx.edu.utez.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clasificacion_curos")
public class Clasificacion_Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclasificacion_curso;

	@NotNull
	private String nombre;

	@OneToMany(mappedBy = "clasificacion_curso")
	private Set<Oferta> oferta = new HashSet<>();

	public Clasificacion_Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Clasificacion_Curso(String nombre, Set<Oferta> oferta) {
		super();
		this.nombre = nombre;
		this.oferta = oferta;
	}

	public Set<Oferta> getOferta() {
		return oferta;
	}

	public void setOferta(Set<Oferta> oferta) {
		this.oferta = oferta;
	}

	public int getIdclasificacion_curso() {
		return idclasificacion_curso;
	}

	public void setIdclasificacion_curso(int idclasificacion_curso) {
		this.idclasificacion_curso = idclasificacion_curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
