package bsk_project.databaseaccesscontrol.security;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

@Singleton
public class LoggedUsers {
	private Map<String, Role> loggedUsers;
	
	public LoggedUsers() {
		loggedUsers = new HashMap<>();
		
		System.out.println("LOGGED USERS CREATED");
	}
	
	public void addUser(String login, Role role) {
		loggedUsers.put(login, role);
	}
	
	public void deleteUser(String login) {
		loggedUsers.remove(login);
	}
	
	public boolean userExists(String login) {
		return loggedUsers.containsKey(login) ? true : false;
	}
	
	public Role getUserRole(String login) {
		return loggedUsers.get(login);
	}
}
