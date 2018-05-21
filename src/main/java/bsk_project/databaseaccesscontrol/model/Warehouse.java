package bsk_project.databaseaccesscontrol.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Warehouse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int warehouseId;
    
    int capacity;
    
    /*@OneToMany
	List<Supply> supplies;
    
    @OneToMany
    List<Part> parts;*/
    
    public Warehouse(int id, int capacity) {
    	this.setWarehouseId(id);
    	this.capacity = capacity;
    }
    
    public Warehouse(int capacity) {
    	this.capacity = capacity;
    }

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
/*
	public List<Supply> getSupplies() {
		return supplies;
	}

	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
*/
	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
}
