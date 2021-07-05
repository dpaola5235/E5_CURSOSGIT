package mx.edu.utez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModalidadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModalidad;
	private String modalidad;
	
	public int getIdModalidad() {
		return idModalidad;
	}
	public void setIdModalidad(int idModalidad) {
		this.idModalidad = idModalidad;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
}
