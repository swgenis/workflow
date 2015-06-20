package coza.opencollab.backbone.authorization.service.impl;

import coza.opencollab.backbone.authorization.User;
import coza.opencollab.backbone.authorization.service.AuthorizationService;
import coza.opencollab.backbone.person.service.impl.PersonMockDataLoader;

/**
 * 
 * @author SW Genis
 * 
 */
public class AuthorizationMockDataLoader {

    public static final String USER1_ID = "jiri";
    public static final String USER2_ID = "mary";
    public static final String USER3_ID = "bob";
    public static final String USER4_ID = "carol";
    public static final String USER5_ID = "john";

    private AuthorizationService authorizationService;

    public AuthorizationMockDataLoader(AuthorizationService authorizationService) {
	this.authorizationService = authorizationService;
    }

    public void loadData() throws Exception {
	addUser(USER1_ID, PersonMockDataLoader.PERSON4_ID);
	addUser(USER2_ID, PersonMockDataLoader.PERSON5_ID);
    }

    private void addUser(String id, String personId) throws Exception {
	User user = new User();
	user.setId(id);
	user.setPersonId(personId);
	authorizationService.insertUser(user);
    }

    

}
