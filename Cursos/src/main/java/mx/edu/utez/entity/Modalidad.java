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
@Table(name = "modalidad" )
public class Modalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_modalidad;
	
	@NotNull
	private String modalidad;

	@OneToMany (mappedBy = "modalidad")
	private Set<Oferta> oferta = new HashSet<>();
	

	public Modalidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Modalidad(String modalidad, Set<Oferta> oferta) {
		super();
		this.modalidad = modalidad;
		this.oferta = oferta;
	}


	public int getId_modalidad() {
		return id_modalidad;
	}

	public void setId_modalidad(int id_modalidad) {
		this.id_modalidad = id_modalidad;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}


	public Set<Oferta> getOferta() {
		return oferta;
	}


	public void setOferta(Set<Oferta> oferta) {
		this.oferta = oferta;
	}
	
	
}
