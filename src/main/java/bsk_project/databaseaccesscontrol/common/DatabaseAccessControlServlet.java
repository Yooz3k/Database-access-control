package bsk_project.databaseaccesscontrol.common;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class DatabaseAccessControlServlet {
	
	private EntityContainer ec = new EntityContainer();
	
	//TEST
	@GET
	@Path("/test/{prodId}")
	public int testInit(@PathParam("prodId") int id) {
		Test testInstance = new Test(id);
		return id;
	}
}
