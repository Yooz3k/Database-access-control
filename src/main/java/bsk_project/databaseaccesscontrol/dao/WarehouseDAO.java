package bsk_project.databaseaccesscontrol.dao;

import java.util.List;

import bsk_project.databaseaccesscontrol.model.Warehouse;

public interface WarehouseDAO {
    public void insert(Warehouse warehouse);
    public List<Warehouse> findAll();
    public void deleteById(int id);
    public void update(Warehouse warehouse);
    public Warehouse find(int id);
}
