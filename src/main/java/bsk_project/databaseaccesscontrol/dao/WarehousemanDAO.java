package bsk_project.databaseaccesscontrol.dao;

import bsk_project.databaseaccesscontrol.model.Warehouseman;

import java.sql.Date;
import java.util.List;

public interface WarehousemanDAO {
    public void insert(Warehouseman warehouseman);
    public List<Warehouseman> findAll();
    public void deleteById(int id);
    public void updateById(int id, String pesel, String nationality, String fullName, Date employmentDate);
}
