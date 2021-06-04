package mx.edu.utez.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "oferta")
public class Oferta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_oferta;

	@NotNull
	private double costo;

	@NotNull
	private int min_participantes;

	@NotNull
	private int max_participantes;

	@NotNull
	private Date fecha_periodo_inscripcion;

	@NotNull
	private Date fecha_inicio;

	@NotNull
	private Date fecha_fin;

	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_modalidad", nullable = false)
	private Modalidad modalidad;

	@ManyToOne
	@JoinColumn(name = "idclasificacion_curso")
	private Clasificacion_Curso clasificacion_curso;

	@ManyToOne
	@JoinColumn(name = "idtipo_curso", nullable = false)
	private Tipo_Curso tipo_curso;

	@ManyToOne
	@JoinColumn(name = "idusuario_profesor", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "oferta")
	private Set<Usuario_Oferta> usuario_oferta = new HashSet<>();

	@OneToMany(mappedBy = "oferta")
	private Set<Diploma> diploma = new HashSet<>();

	@OneToMany(mappedBy = "oferta")
	private Set<Asistencia> asistencia = new HashSet<>();

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oferta(double costo, int min_participantes, int max_participantes, Date fecha_periodo_inscripcion,
			Date fecha_inicio, Date fecha_fin, Curso curso, Modalidad modalidad,
			Clasificacion_Curso clasificacion_curso, Tipo_Curso tipo_curso, Usuario usuario,
			Set<Usuario_Oferta> usuario_oferta, Set<Diploma> diploma, Set<Asistencia> asistencia) {
		super();
		this.costo = costo;
		this.min_participantes = min_participantes;
		this.max_participantes = max_participantes;
		this.fecha_periodo_inscripcion = fecha_periodo_inscripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.curso = curso;
		this.modalidad = modalidad;
		this.clasificacion_curso = clasificacion_curso;
		this.tipo_curso = tipo_curso;
		this.usuario = usuario;
		this.usuario_oferta = usuario_oferta;
		this.diploma = diploma;
		this.asistencia = asistencia;
	}

	public int getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getMin_participantes() {
		return min_participantes;
	}

	public void setMin_participantes(int min_participantes) {
		this.min_participantes = min_participantes;
	}

	public int getMax_participantes() {
		return max_participantes;
	}

	public void setMax_participantes(int max_participantes) {
		this.max_participantes = max_participantes;
	}

	public Date getFecha_periodo_inscripcion() {
		return fecha_periodo_inscripcion;
	}

	public void setFecha_periodo_inscripcion(Date fecha_periodo_inscripcion) {
		this.fecha_periodo_inscripcion = fecha_periodo_inscripcion;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Clasificacion_Curso getClasificacion_curso() {
		return clasificacion_curso;
	}

	public void setClasificacion_curso(Clasificacion_Curso clasificacion_curso) {
		this.clasificacion_curso = clasificacion_curso;
	}

	public Tipo_Curso getTipo_curso() {
		return tipo_curso;
	}

	public void setTipo_curso(Tipo_Curso tipo_curso) {
		this.tipo_curso = tipo_curso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Usuario_Oferta> getUsuario_oferta() {
		return usuario_oferta;
	}

	public void setUsuario_oferta(Set<Usuario_Oferta> usuario_oferta) {
		this.usuario_oferta = usuario_oferta;
	}

	public Set<Diploma> getDiploma() {
		return diploma;
	}

	public void setDiploma(Set<Diploma> diploma) {
		this.diploma = diploma;
	}

	public Set<Asistencia> getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Set<Asistencia> asistencia) {
		this.asistencia = asistencia;
	}

}
