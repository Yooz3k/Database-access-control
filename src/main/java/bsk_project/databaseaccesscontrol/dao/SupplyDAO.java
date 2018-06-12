package bsk_project.databaseaccesscontrol.dao;

import java.util.List;

import bsk_project.databaseaccesscontrol.model.Supply;

public interface SupplyDAO {
    public void insert(Supply supply);
    public List<Supply> findAll();
    public void deleteById(int id);
    public void update(Supply supply);
    public Supply find(int id);
}
