package bsk_project.databaseaccesscontrol.common;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bsk_project.databaseaccesscontrol.dao.PartDAO;
import bsk_project.databaseaccesscontrol.dao.ProducerDAO;
import bsk_project.databaseaccesscontrol.dao.SupplierDAO;
import bsk_project.databaseaccesscontrol.dao.SupplyDAO;
import bsk_project.databaseaccesscontrol.dao.WarehouseDAO;
import bsk_project.databaseaccesscontrol.dao.WarehousemanDAO;
import bsk_project.databaseaccesscontrol.model.Part;
import bsk_project.databaseaccesscontrol.model.Producer;
import bsk_project.databaseaccesscontrol.model.Supplier;
import bsk_project.databaseaccesscontrol.model.Supply;
import bsk_project.databaseaccesscontrol.model.Warehouse;
import bsk_project.databaseaccesscontrol.model.Warehouseman;

public class Test {
	public Test(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	    
	    ProducerDAO producerDAO = (ProducerDAO)context.getBean("producerDAO");
	    WarehouseDAO warehouseDAO = (WarehouseDAO)context.getBean("warehouseDAO");
	    PartDAO partDAO = (PartDAO)context.getBean("partDAO");
	    SupplierDAO supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
	    SupplyDAO supplyDAO = (SupplyDAO)context.getBean("supplyDAO");
	    WarehousemanDAO warehousemanDAO = (WarehousemanDAO)context.getBean("warehousemanDAO");
	    
		Supplier obj = new Supplier("A", "B", "C", new Date(2018, 5, 22));
	    supplierDAO.insert(obj);
	    supplierDAO.updateById(4, "D", "E", "F", new Date(2016, 11, 21));
	    
	    List<Supplier> suppliers = supplierDAO.findAll();
	    
	    for (Supplier ob : suppliers)
	    	System.out.println(ob.toString());
	    
	    supplierDAO.deleteById(suppliers.size());
	    
	    Supply obj2 = new Supply("Supply", new Date(2018, 5, 20), new Time(11, 12, 13), 1, 2, 3);
	    supplyDAO.insert(obj2);
	    supplyDAO.updateById(3, "Supply2", new Date(2018, 5, 20), new Time(11, 12, 13), 1, 2, 3);
	    
	    List<Supply> supplies = supplyDAO.findAll();
	    
	    for (Supply ob : supplies)
	    	System.out.println(ob.toString());
	    
	    supplyDAO.deleteById(supplies.size());
	    
	    Warehouseman obj3 = new Warehouseman("95040315422", "Polska", "Jan Kowalski", new Date(2018, 4, 8));
	    warehousemanDAO.insert(obj3);
	    warehousemanDAO.updateById(3, "77010477229", "Polska", "Maciej Owalski", new Date(2018, 4, 5));
	    
	    List<Warehouseman> warehousemen = warehousemanDAO.findAll();
	    
	    for (Warehouseman ob : warehousemen)
	    	System.out.println(ob.toString());
	    
	    warehouseDAO.deleteById(warehousemen.size());
	}
    
}
