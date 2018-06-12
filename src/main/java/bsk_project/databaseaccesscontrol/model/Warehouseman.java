package bsk_project.databaseaccesscontrol.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouseman {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int warehousemanId;

	String pesel;
	String nationality;
	String fullName;
	Date employmentDate;

	public Warehouseman() {

	}

	public Warehouseman(String pesel, String nationality, String fullName, Date employmentDate) {
		this.pesel = pesel;
		this.nationality = nationality;
		this.fullName = fullName;
		this.employmentDate = employmentDate;
	}

	public Warehouseman(int id, String pesel, String nationality, String fullName, Date employmentDate) {
		this.warehousemanId = id;
		this.pesel = pesel;
		this.nationality = nationality;
		this.fullName = fullName;
		this.employmentDate = employmentDate;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	public int getWarehousemanId() {
		return warehousemanId;
	}

	public void setWarehousemanId(int warehousemanId) {
		this.warehousemanId = warehousemanId;
	}

	@Override
	public String toString() {
		return "Warehouseman [warehousemanId=" + warehousemanId + ", pesel=" + pesel + ", nationality=" + nationality
				+ ", fullName=" + fullName + ", employmentDate=" + employmentDate + "]";
	}
}
