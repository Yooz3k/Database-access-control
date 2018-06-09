package bsk_project.databaseaccesscontrol.security;

public class Operation {
	private CrudOperation crudOperation;
	private Table table;
	
	public Operation(CrudOperation crudOperation, Table table) {
		this.crudOperation = crudOperation;
		this.table = table;
	}
	
	public CrudOperation getCrudOperation() {
		return crudOperation;
	}
	public void setCrudOperation(CrudOperation crudOperation) {
		this.crudOperation = crudOperation;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	
	@Override
	public int hashCode() {
		return crudOperation.ordinal()*100 + table.ordinal();
	}
	
	@Override
	public boolean equals(Object o) {
		Operation op = (Operation)o;
		if (op.crudOperation == this.crudOperation && op.table == this.table)
			return true;
		else
			return false;
	}
}