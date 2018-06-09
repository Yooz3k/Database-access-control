package bsk_project.databaseaccesscontrol.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int supplierId;
	
	String name;
	String city;
	String phoneNumber;
	Date cooperationStartDate;
	
	/*@OneToMany
	List<Supply> supplies;*/
	
	public Supplier() {
		
	}
	
	public Supplier(String name, String city, String phoneNumber, Date cooperationStartDate) {
		this.name = name;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.cooperationStartDate = cooperationStartDate;
	}
	
	public Supplier(int supplierId, String name, String city, String phoneNumber, Date cooperationStartDate) {
		this.supplierId = supplierId;
		this.name = name;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.cooperationStartDate = cooperationStartDate;
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Date getCooperationStartDate() {
		return cooperationStartDate;
	}
	
	public void setCooperationStartDate(Date cooperationStartDate) {
		this.cooperationStartDate = cooperationStartDate;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", name=" + name + ", city=" + city + ", phoneNumber="
				+ phoneNumber + ", cooperationStartDate=" + cooperationStartDate + "]";
	}

	/*public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}*/
}
