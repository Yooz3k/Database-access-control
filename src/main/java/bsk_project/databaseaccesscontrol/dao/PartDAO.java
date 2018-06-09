package bsk_project.databaseaccesscontrol.dao;

import bsk_project.databaseaccesscontrol.model.Part;
import java.util.List;

public interface PartDAO {
    public void insert(Part part);
    public List<Part> findAll();
    public void deleteById(int id);
    public void update(Part part);
    public Part find(int id);
}
