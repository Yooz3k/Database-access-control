package bsk_project.databaseaccesscontrol.dao;

import java.util.List;

import bsk_project.databaseaccesscontrol.model.Producer;

public interface ProducerDAO {
    public void insert(Producer producer);
    public Producer find(int id);
    public List<Producer> findAll();
    public void deleteById(int id);
    public void update(Producer producer);
}
