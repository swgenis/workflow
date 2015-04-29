/**
 * Copyright 2015, Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.ac.nwu.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.kie.api.task.UserGroupCallback;

import za.ac.nwu.workflow.backbone.authorization.Group;
import za.ac.nwu.workflow.backbone.authorization.User;
import za.ac.nwu.workflow.backbone.authorization.service.AuthorizationService;

@Backbone
public class BackboneUserGroupCallback implements UserGroupCallback {

	@Inject
	private AuthorizationService authorizationService;

	public boolean existsUser(String userId) {
		// TODO: Not yet sure why this is required. 
		if(userId.equals("Administrator")){
			return true;
		}
		
		// For everybody else check authorization service.
		User user = authorizationService.getUserById(userId);
		if (user != null) {
			return true;
		}
		return false;
	}

	public boolean existsGroup(String groupId) {
		Group group = authorizationService.getGroupById(groupId);
		if (group != null) {
			return true;
		}
		return false;
	}

	public List<String> getGroupsForUser(String userId, List<String> groupIds,
			List<String> allExistingGroupIds) {
		List<String> groups = new ArrayList<String>();
		if (userId.equals("jiri"))
			groups.add("PM");
		else if (userId.equals("mary"))
			groups.add("HR");
		return groups;
	}
}
