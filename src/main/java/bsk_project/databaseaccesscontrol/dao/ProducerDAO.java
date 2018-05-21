package bsk_project.databaseaccesscontrol.dao;

import bsk_project.databaseaccesscontrol.model.Producer;
import java.util.List;

public interface ProducerDAO {
    public void insert(Producer producer);
    //public Producer findById(int id);
    public List<Producer> findAll();
    public void deleteById(int id);
    public void updateById(int id, String name, String country);
}
