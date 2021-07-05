package mx.edu.utez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClasificacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClasificacion;
	private String clasificacion;
	
	
	public int getIdClasificacion() {
		return idClasificacion;
	}
	public void setIdClasificacion(int idClasificacion) {
		this.idClasificacion = idClasificacion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
}
