package bsk_project.databaseaccesscontrol.common;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bsk_project.databaseaccesscontrol.dao.PartDAO;
import bsk_project.databaseaccesscontrol.dao.ProducerDAO;
import bsk_project.databaseaccesscontrol.dao.SupplierDAO;
import bsk_project.databaseaccesscontrol.dao.SupplyDAO;
import bsk_project.databaseaccesscontrol.dao.WarehouseDAO;
import bsk_project.databaseaccesscontrol.dao.WarehousemanDAO;
import bsk_project.databaseaccesscontrol.model.Producer;
import bsk_project.databaseaccesscontrol.model.Warehouse;

public class Test {
	public Test(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	    
	    ProducerDAO producerDAO = (ProducerDAO)context.getBean("producerDAO");
	    WarehouseDAO warehouseDAO = (WarehouseDAO)context.getBean("warehouseDAO");
	    PartDAO partDAO = (PartDAO)context.getBean("partDAO");
	    SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
	    SupplyDAO supplyDAO = (SupplyDAO)context.getBean("supplyDAO");
	    WarehousemanDAO warehousemanDAO = (WarehousemanDAO)context.getBean("warehousemanDAO");
	    
	    Producer producer = new Producer("TestName", "TestCountry");
	    producerDAO.insert(producer);
	    producerDAO.updateById(1, "UpdateTest", "Update Test Country");
	    
	    List<Producer> producers = producerDAO.findAll();
	    
	    for (Producer prod : producers)
	    	System.out.println(prod.getProducerId() + ", " + 
	    			prod.getName() + ", " + prod.getCountry());
	    
	    producerDAO.deleteById(20);
	}
    
}
