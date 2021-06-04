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
@Table(name = "tipo_curso")
public class Tipo_Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtipo_curso;
	
	@NotNull
	private String tipo;

	@OneToMany (mappedBy = "tipo_curso")
	private Set<Oferta> oferta = new HashSet<>();

	public Tipo_Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipo_Curso(@NotNull String tipo, Set<Oferta> oferta) {
		super();
		this.tipo = tipo;
		this.oferta = oferta;
	}

	public Set<Oferta> getOferta() {
		return oferta;
	}

	public void setOferta(Set<Oferta> oferta) {
		this.oferta = oferta;
	}

	public int getIdtipo_curso() {
		return idtipo_curso;
	}

	public void setIdtipo_curso(int idtipo_curso) {
		this.idtipo_curso = idtipo_curso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
