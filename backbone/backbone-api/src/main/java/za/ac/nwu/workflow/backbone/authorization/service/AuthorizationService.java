package za.ac.nwu.workflow.backbone.authorization.service;

import java.util.List;

import za.ac.nwu.workflow.backbone.authorization.Group;
import za.ac.nwu.workflow.backbone.authorization.User;

/**
 * 
 * @author SW Genis
 * 
 */
public interface AuthorizationService {

    /**
     * 
     * @param userId
     * @return
     */
    public User getUserById(String userId);

    /**
     * 
     * @param personId
     * @return
     */
    public User getUserByPersonId(String personId);

    /**
     * 
     * @param user
     * @throws Exception
     */
    public void insertUser(User user) throws Exception;

    /**
     * 
     * @param user
     */
    public void updateUser(User user);

    /**
     * 
     * @param userId
     */
    public void deleteUser(String userId);

    /**
     * 
     * @param groupId
     * @return
     */
    public Group getGroupById(String groupId);

    /**
     * 
     * @param group
     * @throws Exception
     */
    public void insertGroup(Group group) throws Exception;

    /**
     * 
     * @param group
     */
    public void updateGroup(Group group);

    /**
     * 
     * @param groupId
     */
    public void deleteGroup(String groupId);

    /**
     * 
     * @param userId
     * @return
     */
    public List<String> getGroupIdsForUser(String userId);

}
