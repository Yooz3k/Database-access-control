package bsk_project.databaseaccesscontrol.dao;

import bsk_project.databaseaccesscontrol.model.Part;
import java.util.List;

public interface PartDAO {
    public void insert(Part part);
    public List<Part> findAll();
    public void deleteById(int id);
    public void updateById(int id, String stockNumber, String name, int amount, double price, String category);
}
