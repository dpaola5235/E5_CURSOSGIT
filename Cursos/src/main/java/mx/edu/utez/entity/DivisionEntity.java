package mx.edu.utez.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DivisionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDivisionEntity;
	private String division;
	
	
	public int getIdDivisionEntity() {
		return idDivisionEntity;
	}
	public void setIdDivisionEntity(int idDivisionEntity) {
		this.idDivisionEntity = idDivisionEntity;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
}
