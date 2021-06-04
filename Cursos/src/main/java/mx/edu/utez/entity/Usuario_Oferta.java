package mx.edu.utez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_oferta")
public class Usuario_Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario_oferta;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_oferta", nullable = false)
	private Oferta oferta;

	public Usuario_Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario_Oferta(Usuario usuario, Oferta oferta) {
		super();
		this.usuario = usuario;
		this.oferta = oferta;
	}

	public int getIdusuario_oferta() {
		return idusuario_oferta;
	}

	public void setIdusuario_oferta(int idusuario_oferta) {
		this.idusuario_oferta = idusuario_oferta;
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
