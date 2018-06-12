package bsk_project.databaseaccesscontrol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int warehouseId;

	int capacity;

	public Warehouse() {

	}

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

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	@Override
	public String toString() {
		return "Warehouse [warehouseId=" + warehouseId + ", capacity=" + capacity + "]";
	}
}
