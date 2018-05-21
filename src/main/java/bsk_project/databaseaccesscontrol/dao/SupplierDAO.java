package bsk_project.databaseaccesscontrol.dao;

import bsk_project.databaseaccesscontrol.model.Supplier;

import java.sql.Date;
import java.util.List;

public interface SupplierDAO {
    public void insert(Supplier Supplier);
    public List<Supplier> findAll();
    public void deleteById(int id);
    public void updateById(int id, String name, String city, String phoneNumber, Date cooperationStartDate);
}
