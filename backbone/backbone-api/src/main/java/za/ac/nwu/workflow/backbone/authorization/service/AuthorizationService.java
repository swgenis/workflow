package za.ac.nwu.workflow.backbone.authorization.service;

import java.util.List;

import za.ac.nwu.workflow.backbone.authorization.User;
import za.ac.nwu.workflow.backbone.organization.Group;

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

    

}
