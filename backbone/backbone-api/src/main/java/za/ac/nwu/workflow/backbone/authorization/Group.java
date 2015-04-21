package za.ac.nwu.workflow.backbone.authorization;

import java.util.List;

import za.ac.nwu.workflow.backbone.Entity;

public class Group extends Entity {
	
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
