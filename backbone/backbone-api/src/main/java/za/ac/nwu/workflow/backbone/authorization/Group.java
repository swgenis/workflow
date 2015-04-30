package za.ac.nwu.workflow.backbone.authorization;

import java.util.ArrayList;
import java.util.List;

import za.ac.nwu.workflow.backbone.Entity;

public class Group extends Entity {
	
	private List<User> users;

	public List<User> getUsers() {
		if(users == null){
			users = new ArrayList<User>();
		}
		return users;
	}
	
}
