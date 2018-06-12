package bsk_project.databaseaccesscontrol.dao;

import java.util.List;

import bsk_project.databaseaccesscontrol.model.Supplier;

public interface SupplierDAO {
    public void insert(Supplier Supplier);
    public List<Supplier> findAll();
    public void deleteById(int id);
    public void update(Supplier Supplier);
    public Supplier find(int id);
}
