package bsk_project.databaseaccesscontrol.dao;

import bsk_project.databaseaccesscontrol.model.Warehouse;
import java.util.List;

public interface WarehouseDAO {
    public void insert(Warehouse warehouse);
    //public Producer findById(int id);
    public List<Warehouse> findAll();
    public void deleteById(int id);
    public void updateById(int id, int capacity);
}
