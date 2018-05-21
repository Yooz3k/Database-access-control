package bsk_project.databaseaccesscontrol.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Part {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int partId;
	
	String stockNumber;
	String name;
	int amount;
	double price;
	String category;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	Warehouse warehouse;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Producer producer;*/
	
	int warehouseId;
	int producerId;
	
	public Part(String stockNumber, String name, int amount, double price, String category, int warehouseId, int producerId) {
		this.stockNumber = stockNumber;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.category = category;
		this.warehouseId = warehouseId;
		this.producerId = producerId;
	}

	public Part(int partId, String stockNumber, String name, int amount, double price, String category, int warehouseId, int producerId) {
		this.partId = partId;
		this.stockNumber = stockNumber;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.category = category;
		this.warehouseId = warehouseId;
		this.producerId = producerId;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
/*
	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	*/
	
	public int getWarehouseId() {
		return warehouseId;
	}
	
	public void setWarehouseId(int id) {
		warehouseId = id;
	}
	
	public int getProducerId() {
		return producerId;
	}
	
	public void setProducerId(int id) {
		producerId = id;
	}
	
}
