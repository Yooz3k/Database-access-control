package bsk_project.databaseaccesscontrol.dao;

import java.util.List;

import bsk_project.databaseaccesscontrol.model.Part;

public interface PartDAO {
    public void insert(Part part);
    public List<Part> findAll();
    public void deleteById(int id);
    public void update(Part part);
    public Part find(int id);
}
