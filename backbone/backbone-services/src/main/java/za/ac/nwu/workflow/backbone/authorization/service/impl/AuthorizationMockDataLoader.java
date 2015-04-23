package za.ac.nwu.workflow.backbone.authorization.service.impl;

import za.ac.nwu.workflow.backbone.authorization.AuthorizationService;
import za.ac.nwu.workflow.backbone.authorization.Group;
import za.ac.nwu.workflow.backbone.authorization.User;
import za.ac.nwu.workflow.backbone.person.service.impl.PersonMockDataLoader;

/**
 * 
 * @author SW Genis
 *
 */
public class AuthorizationMockDataLoader {
	
	public static final String USER1_ID = "user1";
	public static final String USER2_ID = "user2";
	public static final String USER3_ID = "user3";
	public static final String USER4_ID = "user4";
	public static final String USER5_ID = "user5";
	public static final String GROUP1_ID = "PM";
	public static final String GROUP2_ID = "HR";

	private AuthorizationService authorizationService;
	
	public AuthorizationMockDataLoader(AuthorizationService authorizationService){
		this.authorizationService = authorizationService;
	}

	public void loadData() throws Exception {
		addUser(USER1_ID, PersonMockDataLoader.PERSON1_ID);
		addUser(USER2_ID, PersonMockDataLoader.PERSON2_ID);
		addUser(USER3_ID, PersonMockDataLoader.PERSON3_ID);
		addUser(USER4_ID, PersonMockDataLoader.PERSON4_ID);
		addUser(USER5_ID, PersonMockDataLoader.PERSON5_ID);
		
		addGroup(GROUP1_ID);
		addGroup(GROUP2_ID);
	}

	private void addUser(String id, String personId) throws Exception {
		User user = new User();
		user.setId(id);
		user.setPersonId(personId);
		authorizationService.insertUser(user);
	}
	
	private void addGroup(String id) throws Exception{
		Group group = new Group();
		group.setId(id);
		authorizationService.insertGroup(group);
	}

}
