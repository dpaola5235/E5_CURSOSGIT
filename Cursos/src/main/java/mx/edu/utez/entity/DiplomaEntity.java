package mx.edu.utez.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DiplomaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDiploma;
	@OneToMany
	private List<Usuario> diplomaUsuarios;
	@OneToMany
	private List<Oferta> ofertas;
	
	
	public int getIdDiploma() {
		return idDiploma;
	}
	public void setIdDiploma(int idDiploma) {
		this.idDiploma = idDiploma;
	}
	public List<Usuario> getDiplomaUsuarios() {
		return diplomaUsuarios;
	}
	public void setDiplomaUsuarios(List<Usuario> diplomaUsuarios) {
		this.diplomaUsuarios = diplomaUsuarios;
	}
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	
}
