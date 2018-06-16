package bsk_project.databaseaccesscontrol.security;

public class Guardian {
	String currentRole = "";
	String login = "";

	public Guardian() {
		this.currentRole = "";
		this.login = "";
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
	}

	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public String getCurrentRole() {
		return currentRole;
	}
	
	public String getLogin() {
		return login;
	}
}
