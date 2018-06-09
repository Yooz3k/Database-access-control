package bsk_project.databaseaccesscontrol.model;

import java.sql.Time;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Supply {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int supplyId;
	
	String shippingNumber;
	Date shippingDate;
	Time shippingTime;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	Supplier supplier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Warehouseman warehouseman;
	
	@ManyToOne(fetch = FetchType.LAZY)
	Warehouse warehouse;*/
	int supplierId;
	int warehousemanId;
	int warehouseId;
	
	public Supply() {
		
	}

	public Supply(String shippingNumber, Date shippingDate, Time shippingTime, int supplierId,
			int warehousemanId, int warehouseId) {
		this.shippingNumber = shippingNumber;
		this.shippingDate = shippingDate;
		this.shippingTime = shippingTime;
		this.supplierId = supplierId;
		this.warehousemanId = warehousemanId;
		this.warehouseId = warehouseId;
	}
	
	public Supply(int supplyId, String shippingNumber, Date shippingDate, Time shippingTime, int supplierId,
			int warehousemanId, int warehouseId) {
		this.supplyId = supplyId;
		this.shippingNumber = shippingNumber;
		this.shippingDate = shippingDate;
		this.shippingTime = shippingTime;
		this.supplierId = supplierId;
		this.warehousemanId = warehousemanId;
		this.warehouseId = warehouseId;
	}

	public int getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
	}

	public String getShippingNumber() {
		return shippingNumber;
	}

	public void setShippingNumber(String shippingNumber) {
		this.shippingNumber = shippingNumber;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Time getShippingTime() {
		return shippingTime;
	}

	public void setShippingTime(Time shippingTime) {
		this.shippingTime = shippingTime;
	}
/*
	public Supplier getSupplierId() {
		return supplier;
	}

	public void setSupplierId(Supplier supplierId) {
		this.supplier = supplierId;
	}

	public Warehouseman getWarehousemanId() {
		return warehouseman;
	}

	public void setWarehousemanId(Warehouseman warehousemanId) {
		this.warehouseman = warehousemanId;
	}

	public Warehouse getWarehouseId() {
		return warehouse;
	}

	public void setWarehouseId(Warehouse warehouseId) {
		this.warehouse = warehouseId;
	}*/

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getWarehousemanId() {
		return warehousemanId;
	}

	public void setWarehousemanId(int warehousemanId) {
		this.warehousemanId = warehousemanId;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	@Override
	public String toString() {
		return "Supply [supplyId=" + supplyId + ", shippingNumber=" + shippingNumber + ", shippingDate=" + shippingDate
				+ ", shippingTime=" + shippingTime + ", supplierId=" + supplierId + ", warehousemanId=" + warehousemanId
				+ ", warehouseId=" + warehouseId + "]";
	}
	
	
}
