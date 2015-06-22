package coza.opencollab.backbone.authorization.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import coza.opencollab.backbone.authorization.User;
import coza.opencollab.backbone.authorization.service.AuthorizationService;
import coza.opencollab.backbone.qualifiers.MapService;

/**
 * 
 * This class is a singleton to force the application server not to create more than
 * one instance of the service. A non-map based service should not be a singleton.
 * 
 * @author SW Genis
 *
 */
@MapService
@Singleton
public class AuthorizationServiceMapImpl implements AuthorizationService {

    private Map<String, User> users = new HashMap<String, User>();

    @Override
    public User getUserById(String userId) {
	if (users.containsKey(userId)) {
	    return users.get(userId);
	}
	return null;
    }

    @Override
    public User getUserByPersonId(String personId) {
	for (User user : users.values()) {
	    if (user.getPersonId().equals(personId)) {
		return user;
	    }
	    ;
	}
	return null;
    }

    @Override
    public void insertUser(User user) throws Exception {
	if (users.containsKey(user.getId())) {
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

    

}
