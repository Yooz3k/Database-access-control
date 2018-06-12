package bsk_project.databaseaccesscontrol.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoleContainer {
	List<Role> roles;

	public RoleContainer() {
		roles = new ArrayList<>();
		setRoles();
	}

	public Role getRole(String name) {
		for (Role role : roles)
			if (role.getName().equals(name))
				return role;

		return null;
	}

	private void setRoles() {
		Role warehouseman = new Role("warehouseman");
		Map<Operation, Boolean> operationAccess = new HashMap<>();

		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIES), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSES), false);

		operationAccess.put(new Operation(CrudOperation.READ, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSES), false);

		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSES), false);

		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIES), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSES), false);

		warehouseman.setAccessTable(operationAccess);
		roles.add(warehouseman);

		Role logistician = new Role("logistician");
		operationAccess = new HashMap<>();

		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIERS), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSES), false);

		operationAccess.put(new Operation(CrudOperation.READ, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.PRODUCERS), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIERS), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSES), true);

		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIERS), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSES), true);

		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSEMEN), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSES), false);

		logistician.setAccessTable(operationAccess);
		roles.add(logistician);

		Role hrEmployee = new Role("hrEmployee");
		operationAccess = new HashMap<>();

		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIES), false);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSES), false);

		operationAccess.put(new Operation(CrudOperation.READ, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIES), false);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSES), false);

		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIES), false);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSES), false);

		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PARTS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PRODUCERS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIERS), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIES), false);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSES), false);

		hrEmployee.setAccessTable(operationAccess);
		roles.add(hrEmployee);

		Role manager = new Role("manager");
		operationAccess = new HashMap<>();

		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.PRODUCERS), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIERS), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.CREATE, Table.WAREHOUSES), true);

		operationAccess.put(new Operation(CrudOperation.READ, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.PRODUCERS), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIERS), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.READ, Table.WAREHOUSES), true);

		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.PRODUCERS), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIERS), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.UPDATE, Table.WAREHOUSES), true);

		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PARTS), true);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.PRODUCERS), true);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIERS), true);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.SUPPLIES), true);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSEMEN), true);
		operationAccess.put(new Operation(CrudOperation.DELETE, Table.WAREHOUSES), true);

		manager.setAccessTable(operationAccess);
		roles.add(manager);
	}
}
