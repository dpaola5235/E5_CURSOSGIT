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
	private Date fechaPeriodoInscripcion;
	private Date fechaInicio;
	private Date fechaFin;
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
	public Date getFechaPeriodoInscripcion() {
		return fechaPeriodoInscripcion;
	}
	public void setFechaPeriodoInscripcion(Date fechaPeriodoInscripcion) {
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
	
	
	
	
}
