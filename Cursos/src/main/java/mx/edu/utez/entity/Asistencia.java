package mx.edu.utez.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "asistencia")
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_asistencia;
	
	@NotNull
	private Date fecha_asistencia;
	
	@NotNull
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_oferta", nullable = false)
	private Oferta oferta;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	public Asistencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asistencia( Date fecha_asistencia,  String estado, Oferta oferta, Usuario usuario) {
		super();
		this.fecha_asistencia = fecha_asistencia;
		this.estado = estado;
		this.oferta = oferta;
		this.usuario = usuario;
	}

	public int getId_asistencia() {
		return id_asistencia;
	}

	public void setId_asistencia(int id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	public Date getFecha_asistencia() {
		return fecha_asistencia;
	}

	public void setFecha_asistencia(Date fecha_asistencia) {
		this.fecha_asistencia = fecha_asistencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
