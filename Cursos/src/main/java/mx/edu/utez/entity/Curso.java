package mx.edu.utez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_curso;
	@NotNull
	private String titulo;
	@NotNull
	private String descripcion;
	@NotNull
	private String requisitos;
	@NotNull
	private String temario;
	@NotNull
	private String duracion;

	public Curso(String titulo, String descripcion, String requisitos, String temario, String duracion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.temario = temario;
		this.duracion = duracion;
	}

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getTemario() {
		return temario;
	}

	public void setTemario(String temario) {
		this.temario = temario;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

}
