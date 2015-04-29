package za.ac.nwu.workflow.backbone.authorization.service;

import java.util.List;

import za.ac.nwu.workflow.backbone.authorization.Group;
import za.ac.nwu.workflow.backbone.authorization.User;

public interface AuthorizationService {
	
	public User getUserById(String userId);
	
	public void insertUser(User user) throws Exception;
	
	public void updateUser(User user);
	
	public void deleteUser(String userId);
	
	public Group getGroupById(String groupId);
	
	public void insertGroup(Group group) throws Exception;
	
	public void updateGroup(Group group);
	
	public void deleteGroup(String groupId);
	
	public List<String> getGroupIdsForUser(String userId);

}
