package bsk_project.databaseaccesscontrol.security;

import java.util.HashMap;
import java.util.Map;

public class Role {
	private String name;
	private Map<Operation, Boolean> operationAccess;

	public Role(String name) {
		setName(name);
		setAccessTable(new HashMap<Operation, Boolean>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Operation, Boolean> getAccessTable() {
		return operationAccess;
	}

	public void setAccessTable(Map<Operation, Boolean> operationAccess) {
		this.operationAccess = operationAccess;
	}

	public Boolean getAccess(Operation operation) {
		return operationAccess.get(operation);
	}
}
