package mx.edu.utez.entity;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	@NotNull
	private String nombre;
	@NotNull
	private String apellidos;
	@Email
	private String correo_electronico;
	@NotNull
	private String contrasena;

	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false)
	private Rol rol;

	@OneToMany (mappedBy = "usuario")
	private Set<Usuario_Oferta> usuario_oferta = new HashSet<>();

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(@NotNull String nombre, @NotNull String apellidos, @Email String correo_electronico,
			@NotNull String contrasena, Rol rol, Set<Usuario_Oferta> usuario_oferta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
		this.rol = rol;
		this.usuario_oferta = usuario_oferta;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Set<Usuario_Oferta> getUsuario_oferta() {
		return usuario_oferta;
	}

	public void setUsuario_oferta(Set<Usuario_Oferta> usuario_oferta) {
		this.usuario_oferta = usuario_oferta;
	}

	
}
