package bsk_project.databaseaccesscontrol.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	private ServletContext ctx;
	
	@Context
	private HttpServletRequest request;

	private Guardian guardian;
	private EntityContainer ec = new EntityContainer();
	private RoleContainer rc = new RoleContainer();
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(String json) {
		JSONObject jo = new JSONObject(json);
		
		String loginInput = (String)jo.get("login");
		String passwordInput = (String)jo.get("password");
		String roleInput = (String)jo.get("role");
		
		String filePath = ctx.getRealPath("/") + "users.json";
		
		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
			content = content.replace("\\", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
            			request.getSession().setAttribute("guardian", guardian);
            			return Response.status(Response.Status.NO_CONTENT).build();
            		}
            	}
            }
    	}
    	guardian = new Guardian();
    	request.getSession().setAttribute("guardian", guardian);
    	return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@GET
	@Path("/parts/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllParts() {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.READ, Table.PARTS)))
			return Response.status(Response.Status.OK).entity(ec.getPartDAO().findAll()).build();
		else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/parts/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPart(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
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
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/parts/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePart(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.UPDATE, Table.PARTS))) {
			JSONObject jo = new JSONObject(json);
			
			Part part = new Part();
			part.setPartId(jo.getInt("id"));
			part.setStockNumber((String)jo.get("stockNumber"));
			part.setName((String)jo.get("name"));
			part.setAmount(jo.getInt("amount"));
			part.setPrice(jo.getDouble("price"));
			part.setCategory((String)jo.getString("category"));
			ec.getPartDAO().update(part);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/parts/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletePart(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.DELETE, Table.PARTS))) {
			JSONObject jo = new JSONObject(json);
			ec.getPartDAO().deleteById(jo.getInt("partId"));
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@GET
	@Path("/producers/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProducers() {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.READ, Table.PRODUCERS)))
			return Response.status(Response.Status.OK).entity(ec.getProducerDAO().findAll()).build();
		else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/producers/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProducer(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.CREATE, Table.PRODUCERS))) {
			JSONObject jo = new JSONObject(json);
			
			Producer producer = new Producer();
			producer.setName((String)jo.get("name"));
			producer.setCountry((String)jo.get("country"));
			
			ec.getProducerDAO().insert(producer);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/producers/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProducer(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.UPDATE, Table.PRODUCERS))) {
			JSONObject jo = new JSONObject(json);
			
			Producer producer = new Producer();
			producer.setProducerId(jo.getInt("id"));
			producer.setName((String)jo.get("name"));
			producer.setCountry((String)jo.get("country"));
			
			ec.getProducerDAO().update(producer);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/producers/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteProducer(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.DELETE, Table.PRODUCERS))) {
			JSONObject jo = new JSONObject(json);
			ec.getProducerDAO().deleteById(jo.getInt("producerId"));
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@GET
	@Path("/suppliers/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSuppliers() {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.READ, Table.SUPPLIERS)))
			return Response.status(Response.Status.OK).entity(ec.getSupplierDAO().findAll()).build();
		else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/suppliers/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSupplier(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.CREATE, Table.SUPPLIERS))) {
			JSONObject jo = new JSONObject(json);
			
			Supplier supplier = new Supplier();
			supplier.setName((String)jo.get("name"));
			supplier.setCity((String)jo.get("city"));
			supplier.setPhoneNumber((String)jo.get("phoneNumber"));
			supplier.setCooperationStartDate((Date)jo.get("cooperationStartDate"));

			ec.getSupplierDAO().insert(supplier);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/suppliers/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSupplier(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.UPDATE, Table.SUPPLIERS))) {
			JSONObject jo = new JSONObject(json);
			
			Supplier supplier = new Supplier();
			supplier.setSupplierId(jo.getInt("id"));
			supplier.setName((String)jo.get("name"));
			supplier.setCity((String)jo.get("city"));
			supplier.setPhoneNumber((String)jo.get("phoneNumber"));
			supplier.setCooperationStartDate((Date)jo.get("cooperationStartDate"));

			ec.getSupplierDAO().update(supplier);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/suppliers/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSupplier(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.DELETE, Table.SUPPLIERS))) {
			JSONObject jo = new JSONObject(json);
			ec.getSupplierDAO().deleteById(jo.getInt("supplierID"));
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@GET
	@Path("/supplies/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllSupplies() {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.READ, Table.SUPPLIES)))
			return Response.status(Response.Status.OK).entity(ec.getSupplyDAO().findAll()).build();
		else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/supplies/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSupply(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.CREATE, Table.SUPPLIES))) {
			JSONObject jo = new JSONObject(json);
			
			Supply supply = new Supply();
			supply.setShippingNumber((String)jo.get("shippingNumber"));
			supply.setShippingDate((Date)jo.get("shippingDate"));
			supply.setShippingTime((Time)jo.get("shippingTime"));
			supply.setSupplierId(jo.getInt("supplierId"));
			supply.setWarehousemanId(jo.getInt("warehousemanId"));
			supply.setWarehouseId(jo.getInt("warehouseId"));
			
			ec.getSupplyDAO().insert(supply);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/supplies/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSupply(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.UPDATE, Table.SUPPLIES))) {
			JSONObject jo = new JSONObject(json);
			
			Supply supply = new Supply();
			supply.setSupplyId(jo.getInt("id"));
			supply.setShippingNumber((String)jo.get("shippingNumber"));
			supply.setShippingDate((Date)jo.get("shippingDate"));
			supply.setShippingTime((Time)jo.get("shippingTime"));
			supply.setSupplierId(jo.getInt("supplierId"));
			supply.setWarehousemanId(jo.getInt("warehousemanId"));
			supply.setWarehouseId(jo.getInt("warehouseId"));
			
			ec.getSupplyDAO().update(supply);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/supplies/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSupply(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.DELETE, Table.SUPPLIES))) {
			JSONObject jo = new JSONObject(json);
			ec.getSupplyDAO().deleteById(jo.getInt("supplyId"));
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@GET
	@Path("/warehousemen/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllWarehousemen() {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.READ, Table.WAREHOUSEMEN)))
			return Response.status(Response.Status.OK).entity(ec.getWarehousemanDAO().findAll()).build();
		else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/warehousemen/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addWarehouseman(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.CREATE, Table.WAREHOUSEMEN))) {
			JSONObject jo = new JSONObject(json);
			
			Warehouseman warehouseman = new Warehouseman();
			warehouseman.setPesel((String)jo.get("pesel"));
			warehouseman.setNationality((String)jo.get("nationality"));
			warehouseman.setFullName((String)jo.get("fullName"));
			warehouseman.setEmploymentDate((Date)jo.get("employmentDate"));
			
			ec.getWarehousemanDAO().insert(warehouseman);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/warehousemen/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWarehouseman(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.UPDATE, Table.WAREHOUSEMEN))) {
			JSONObject jo = new JSONObject(json);
			
			Warehouseman warehouseman = new Warehouseman();
			warehouseman.setWarehousemanId(jo.getInt("id"));
			warehouseman.setPesel((String)jo.get("pesel"));
			warehouseman.setNationality((String)jo.get("nationality"));
			warehouseman.setFullName((String)jo.get("fullName"));
			warehouseman.setEmploymentDate((Date)jo.get("employmentDate"));
			
			ec.getWarehousemanDAO().update(warehouseman);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/warehousemen/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWarehouseman(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.DELETE, Table.WAREHOUSEMEN))) {
			JSONObject jo = new JSONObject(json);
			ec.getWarehousemanDAO().deleteById(jo.getInt("warehousemanId"));
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@GET
	@Path("/warehouses/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllWarehouses() {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.READ, Table.WAREHOUSES)))
			return Response.status(Response.Status.OK).entity(ec.getWarehouseDAO().findAll()).build();
		else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/warehouses/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addWarehouse(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.CREATE, Table.WAREHOUSES))) {
			JSONObject jo = new JSONObject(json);
			
			Warehouse warehouse = new Warehouse();
			warehouse.setCapacity(jo.getInt("capacity"));
			
			ec.getWarehouseDAO().insert(warehouse);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/warehouses/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWarehouse(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.UPDATE, Table.WAREHOUSES))) {
			JSONObject jo = new JSONObject(json);
			
			Warehouse warehouse = new Warehouse();
			warehouse.setWarehouseId(jo.getInt("id"));
			warehouse.setCapacity(jo.getInt("capacity"));
			
			ec.getWarehouseDAO().update(warehouse);
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
	
	@POST
	@Path("/warehouses/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWarehouse(String json) {
		guardian = new Guardian((Guardian)request.getSession().getAttribute("guardian"));
		if (rc.getRole(guardian.getCurrentRole()).getAccess(new Operation(CrudOperation.DELETE, Table.WAREHOUSES))) {
			JSONObject jo = new JSONObject(json);
			ec.getWarehouseDAO().deleteById(jo.getInt("warehouseId"));
			
			return Response.status(Response.Status.CREATED).build();
		} else
			return Response.status(Response.Status.UNAUTHORIZED).build();
	}
}
