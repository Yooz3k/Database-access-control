package bsk_project.databaseaccesscontrol.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import bsk_project.databaseaccesscontrol.model.Part;
import bsk_project.databaseaccesscontrol.model.Producer;
import bsk_project.databaseaccesscontrol.model.Supplier;
import bsk_project.databaseaccesscontrol.model.Supply;
import bsk_project.databaseaccesscontrol.model.Warehouse;
import bsk_project.databaseaccesscontrol.model.Warehouseman;
import bsk_project.databaseaccesscontrol.security.CrudOperation;
import bsk_project.databaseaccesscontrol.security.Guardian;
import bsk_project.databaseaccesscontrol.security.Operation;
import bsk_project.databaseaccesscontrol.security.RoleContainer;
import bsk_project.databaseaccesscontrol.security.Table;

@Path("/")
public class DatabaseAccessControlServlet {
	
	@Context
	ServletContext ctx;
	
	@Singleton
	private Guardian guardian;
	
	private EntityContainer ec = new EntityContainer();
	private RoleContainer rc = new RoleContainer();
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public int login(String json) {
		JSONObject jo = new JSONObject(json);
		
		String loginInput = (String)jo.get("login");
		String passwordInput = (String)jo.get("password");
		String roleInput = "warehousemanRole";	//(String)jo.get("role");
		
		String filePath = ctx.getRealPath("/") + "users.json";
		
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
			content = content.replace("\\", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String fileCont="[{\"login\":\"user\",\"password\":\"123\",\"warehousemanRole\":1,\"logisticianRole\":0,\"hrEmployeeRole\":0,\"managerRole\":0},{\"login\":\"manager\",\"password\":\"234\",\"warehousemanRole\":0,\"logisticianRole\":0,\"hrEmployeeRole\":0,\"managerRole\":1}]";
		
		JSONArray ja = new JSONArray(content);
		String login;
    	String password;
    	int roleValue;
    	
    	for (int i = 0; i < ja.length(); i++) {
    		JSONObject obj = ja.getJSONObject(i);
    		
    		login = (String)obj.get("login");
            if (login.equals(loginInput)) {
            	password = (String)obj.get("password");
            	if (password.equals(passwordInput)) { 
            		roleValue = (int)obj.getInt(roleInput);
            		if (roleValue == 1) {
            			guardian = new Guardian(roleInput, login);
            			return 1;
            		}
            	}
            }
    	}
    	guardian = new Guardian();
	    return 0;
	}
	
	@GET
	@Path("/parts/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Part> findAllParts() {
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.READ, Table.PARTS)))
			return ec.getPartDAO().findAll();
		else
			return null;
	}
	
	@POST
	@Path("/parts/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPart(String json) {
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.CREATE, Table.PARTS))) {
			JSONObject jo = new JSONObject(json);
			
			Part part = new Part();
			part.setStockNumber((String)jo.get("stockNumber"));
			part.setName((String)jo.get("name"));
			part.setAmount(jo.getInt("amount"));
			part.setPrice(jo.getDouble("price"));
			part.setCategory((String)jo.getString("category"));
			part.setWarehouseId(jo.getInt("warehouseId"));
			part.setProducerId(jo.getInt("producerId"));
			ec.getPartDAO().insert(part);
		}
	}
	
	@POST
	@Path("/parts/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePart(String json) {
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.UPDATE, Table.PARTS))) {
			JSONObject jo = new JSONObject(json);
			System.out.println(json);
			
			Part part = new Part();
			part.setPartId(jo.getInt("id"));
			part.setStockNumber((String)jo.get("stockNumber"));
			part.setName((String)jo.get("name"));
			part.setAmount(jo.getInt("amount"));
			part.setPrice(jo.getDouble("price"));
			part.setCategory((String)jo.getString("category"));
			ec.getPartDAO().update(part);
		}
	}
	
	@POST
	@Path("/parts/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletePart(String json) {
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.DELETE, Table.PARTS))) {
			JSONObject jo = new JSONObject(json);
			ec.getPartDAO().deleteById(jo.getInt("partId"));
		}
	}
	
	@GET
	@Path("/producers/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producer> findAllProducers() {
		return ec.getProducerDAO().findAll();
	}
	
	@GET
	@Path("/suppliers/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Supplier> findAllSuppliers() {
		return ec.getSupplierDAO().findAll();
	}
	
	@GET
	@Path("/supplies/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Supply> findAllSupplies() {
		return ec.getSupplyDAO().findAll();
	}
	
	@GET
	@Path("/warehousemen/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Warehouseman> findAllWarehousemen() {
		return ec.getWarehousemanDAO().findAll();
	}
	
	@GET
	@Path("/warehouses/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Warehouse> findAllWarehouses() {
		return ec.getWarehouseDAO().findAll();
	}
	
	
}
