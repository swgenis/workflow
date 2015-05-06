package za.ac.nwu.workflow.backbone.authorization.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Singleton;

import za.ac.nwu.workflow.backbone.authorization.User;
import za.ac.nwu.workflow.backbone.authorization.service.AuthorizationService;
import za.ac.nwu.workflow.backbone.organization.Group;

/**
 * 
 * This class is a singleton to force the application server not to create more than
 * one instance of the service. A non-map based service should not be a singleton.
 * 
 * @author SW Genis
 *
 */
@Default
@Singleton
public class AuthorizationServiceMapImpl implements AuthorizationService {

    private Map<String, User> users = new HashMap<String, User>();

    @PostConstruct
    public void initialize() throws Exception {
	AuthorizationMockDataLoader dataLoader = new AuthorizationMockDataLoader(this);
	try {
	    dataLoader.loadData();
	} catch (Exception e) {
	    throw new Exception("Unable to load data for AuthorizationServiceMapImpl", e);
	}
    }

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
