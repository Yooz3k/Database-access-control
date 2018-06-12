package bsk_project.databaseaccesscontrol.dao;

import java.util.List;

import bsk_project.databaseaccesscontrol.model.Warehouseman;

public interface WarehousemanDAO {
    public void insert(Warehouseman warehouseman);
    public List<Warehouseman> findAll();
    public void deleteById(int id);
    public void update(Warehouseman warehouseman);
    public Warehouseman find(int id);
}
