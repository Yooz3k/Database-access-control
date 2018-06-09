package bsk_project.databaseaccesscontrol.security;

public enum Table {
	PARTS("Parts"),
	PRODUCERS("Producers"),
	SUPPLIERS("Suppliers"),
	SUPPLIES("Supplies"),
	WAREHOUSES("Warehouses"),
	WAREHOUSEMEN("Warehousemen");

	private final String value;
	
	private Table(final String value) {
		this.value = value;
	}
}