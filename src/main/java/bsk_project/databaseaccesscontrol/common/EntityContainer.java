package bsk_project.databaseaccesscontrol.common;

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

public class EntityContainer {
	ApplicationContext context;
	
	private PartDAO partDAO;
	private ProducerDAO producerDAO;
	private SupplierDAO supplierDAO;
	private SupplyDAO supplyDAO;
	private WarehouseDAO warehouseDAO;
	private WarehousemanDAO warehousemanDAO;
	
	private Part part;
	private Producer producer;
	private Supplier supplier;
	private Supply supply;
	private Warehouse warehouse;
	private Warehouseman warehouseman;
	
	
	public EntityContainer() {
		context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	    
	    producerDAO = (ProducerDAO)context.getBean("producerDAO");
	    warehouseDAO = (WarehouseDAO)context.getBean("warehouseDAO");
	    partDAO = (PartDAO)context.getBean("partDAO");
	    supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
	    supplyDAO = (SupplyDAO)context.getBean("supplyDAO");
	    warehousemanDAO = (WarehousemanDAO)context.getBean("warehousemanDAO");
	}


	public PartDAO getPartDAO() {
		return partDAO;
	}


	public ProducerDAO getProducerDAO() {
		return producerDAO;
	}


	public SupplierDAO getSupplierDAO() {
		return supplierDAO;
	}


	public SupplyDAO getSupplyDAO() {
		return supplyDAO;
	}


	public WarehouseDAO getWarehouseDAO() {
		return warehouseDAO;
	}


	public WarehousemanDAO getWarehousemanDAO() {
		return warehousemanDAO;
	}
}
