package bsk_project.databaseaccesscontrol.security;

public enum CrudOperation {
	CREATE("Create"),
	READ("Read"),
	UPDATE("Update"),
	DELETE("Delete");
	
	private final String value;
	
	private CrudOperation(final String value) {
		this.value = value;
	}
}
