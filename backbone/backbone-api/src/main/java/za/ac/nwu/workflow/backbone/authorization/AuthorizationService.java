package za.ac.nwu.workflow.backbone.authorization;

import java.util.List;

public interface AuthorizationService {
	
	public User getUserById(String userId);
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(String userId);
	
	public Group getGroupById(String groupId);
	
	public void insertGroup(Group group);
	
	public void updateGroup(Group group);
	
	public void deleteGroup(String groupId);
	
	public List<String> getGroupIdsForUser(String userId);

}
