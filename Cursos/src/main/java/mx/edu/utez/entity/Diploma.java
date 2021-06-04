package mx.edu.utez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "diploma")
public class Diploma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_diploma;
	
	@NotBlank
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_oferta", nullable = false)
	private Oferta oferta;

	public Diploma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diploma(@NotBlank boolean estado, Usuario usuario, Oferta oferta) {
		super();
		this.estado = estado;
		this.usuario = usuario;
		this.oferta = oferta;
	}

	public int getId_diploma() {
		return id_diploma;
	}

	public void setId_diploma(int id_diploma) {
		this.id_diploma = id_diploma;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	
}
