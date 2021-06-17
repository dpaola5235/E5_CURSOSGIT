package mx.edu.utez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClasificacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClasifiacionEntity;
	private String clasificacion;
	public int getIdClasifiacionEntity() {
		return idClasifiacionEntity;
	}
	public void setIdClasifiacionEntity(int idClasifiacionEntity) {
		this.idClasifiacionEntity = idClasifiacionEntity;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
}
