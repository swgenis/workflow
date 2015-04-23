package za.ac.nwu.workflow.backbone.authorization.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import za.ac.nwu.workflow.backbone.authorization.AuthorizationService;
import za.ac.nwu.workflow.backbone.authorization.Group;
import za.ac.nwu.workflow.backbone.authorization.User;

public class AuthorizationServiceMapImpl implements AuthorizationService {
	
	private Map<String, User> users = new HashMap<String, User>();
	private Map<String, Group> groups = new HashMap<String, Group>();
	
	@PostConstruct
	public void initialize() throws Exception{
		AuthorizationMockDataLoader dataLoader = new AuthorizationMockDataLoader(this);
		try {
			dataLoader.loadData();
		} catch (Exception e) {
			throw new Exception("Unable to load data for AuthorizationServiceMapImpl", e);
		}
	}

	@Override
	public User getUserById(String userId) {
		if(users.containsKey(userId)){
			return users.get(userId);
		}
		return null;
	}

	@Override
	public void insertUser(User user) throws Exception {
		if(users.containsKey(user.getId())){
			throw new Exception("User already exists for id " + user.getId());
		}
		users.put(user.getId(), user);	
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Group getGroupById(String groupId) {
		if(groups.containsKey(groupId)){
			return groups.get(groupId);
		}
		return null;
	}

	@Override
	public void insertGroup(Group group) throws Exception {
		if(groups.containsKey(group.getId())){
			throw new Exception("Group already exists for id " + group.getId());
		}
		groups.put(group.getId(), group);	
	}

	@Override
	public void updateGroup(Group group) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGroup(String groupId) {
		// TODO Auto-generated method stub

	}
	
	public List<String> getGroupIdsForUser(String userId){
		List<String> groupIds = new ArrayList<String>();
		for(Group group : groups.values()){
			if(isUserInGroup(userId, group)){
				groupIds.add(group.getId());
			}
		}
		return groupIds;
	}

	private boolean isUserInGroup(String userId, Group group) {
		for(User user : group.getUsers()){
			if(user.getId().equals(userId)){
				return true;
			}
		}
		return false;
	}

}
