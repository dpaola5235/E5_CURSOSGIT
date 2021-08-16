package mx.edu.utez.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AsistenciaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsistencia;
	@ManyToOne
	private Usuario estudiante;
	@ManyToOne
	private Oferta oferta;
	private Date fechaAsistencia;
	private String estado;
	 
	public int getIdAsistencia() {
		return idAsistencia;
	}
	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}
	public Usuario getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Usuario estudiante) {
		this.estudiante = estudiante;
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	public Date getFechaAsistencia() {
		return fechaAsistencia;
	}
	public void setFechaAsistencia(Date fechaAsistencia) {
		this.fechaAsistencia = fechaAsistencia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "AsistenciaEntity [idAsistencia=" + idAsistencia + ", estudiante=" + estudiante + ", oferta=" + oferta
				+ ", fechaAsistencia=" + fechaAsistencia + ", estado=" + estado + "]";
	}
	
}
