package bsk_project.databaseaccesscontrol.dao;

import bsk_project.databaseaccesscontrol.model.Supply;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

public interface SupplyDAO {
    public void insert(Supply supply);
    public List<Supply> findAll();
    public void deleteById(int id);
    public void updateById(int id, String shippingNumber, Date shippingDate, Time shippingTime, int supplierId,
			int warehousemanId, int warehouseId);
}
