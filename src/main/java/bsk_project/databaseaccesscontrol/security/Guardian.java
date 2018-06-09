package bsk_project.databaseaccesscontrol.security;

public class Guardian {
	String currentRole;
	String login;
	
	public Guardian(String role) {
		currentRole = role;
	}
	
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public String getCurrentRole() {
		return currentRole;
	}	
}
