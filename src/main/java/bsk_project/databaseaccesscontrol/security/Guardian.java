package bsk_project.databaseaccesscontrol.security;

public class Guardian {
	String currentRole = "";
	String login = "";
	
	public Guardian() {
		this.currentRole = "";
		this.login = "";
		
		System.out.println("1 New GUARDIAN: " + login + " " + currentRole);
	}
	
	public Guardian(Guardian guardian) {
		if (guardian == null) {
			this.currentRole = "";
			this.login = "";
		} else {
			this.currentRole = guardian.getCurrentRole();
			this.login = guardian.login;
		}
	}
	
	public Guardian(String role, String login) {
		this.currentRole = role;
		this.login = login;
		
		System.out.println("2 New GUARDIAN: " + login + " " + currentRole);
	}
	
	
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public String getCurrentRole() {
		return currentRole;
	}	
}
