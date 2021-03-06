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
	// diplomado o taller
	private String tipoCurso;
	private String fechaPeriodoInscripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;
	@ManyToMany
	private List<CursoEntity> cursos;
	@ManyToMany
	private List<ModalidadEntity> modalidades;
	@ManyToMany
	private List<ClasificacionEntity> clasificaciones;
	@ManyToMany
	private List<DivisionEntity> divisiones;
	
	@ManyToOne 
	private Usuario docente;
	
	
	public int getIdOferta() {
		return idOferta;
	}
	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getMinimoParticipantes() {
		return minimoParticipantes;
	}
	public String getTipoCurso() {
		return tipoCurso;
	}
	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	
	public void setMinimoParticipantes(int minimoParticipantes) {
		this.minimoParticipantes = minimoParticipantes;
	}
	public int getMaximoParticipantes() {
		return maximoParticipantes;
	}
	public void setMaximoParticipantes(int maximoParticipantes) {
		this.maximoParticipantes = maximoParticipantes;
	}
	public String getFechaPeriodoInscripcion() {
		return fechaPeriodoInscripcion;
	}
	public void setFechaPeriodoInscripcion(String fechaPeriodoInscripcion) {
		this.fechaPeriodoInscripcion = fechaPeriodoInscripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public List<CursoEntity> getCursos() {
		return cursos;
	}
	public void setCursos(List<CursoEntity> cursos) {
		this.cursos = cursos;
	}
	public List<ModalidadEntity> getModalidades() {
		return modalidades;
	}
	public void setModalidades(List<ModalidadEntity> modalidades) {
		this.modalidades = modalidades;
	}
	public List<ClasificacionEntity> getClasificaciones() {
		return clasificaciones;
	}
	public void setClasificaciones(List<ClasificacionEntity> clasificaciones) {
		this.clasificaciones = clasificaciones;
	}
	public List<DivisionEntity> getDivisiones() {
		return divisiones;
	}
	public void setDivisiones(List<DivisionEntity> divisiones) {
		this.divisiones = divisiones;
	}
	public Usuario getDocente() {
		return docente;
	}
	public void setDocente(Usuario docente) {
		this.docente = docente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Oferta [idOferta=" + idOferta + ", costo=" + costo + ", minimoParticipantes=" + minimoParticipantes
				+ ", maximoParticipantes=" + maximoParticipantes + ", tipoCurso=" + tipoCurso
				+ ", fechaPeriodoInscripcion=" + fechaPeriodoInscripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", estado=" + estado + ", cursos=" + cursos + ", modalidades="
				+ modalidades + ", clasificaciones=" + clasificaciones + ", divisiones=" + divisiones + ", docente="
				+ docente + "]";
	}
	
	
	
	
	
}
