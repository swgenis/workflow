package coza.opencollab.backbone.organization;

import java.util.ArrayList;
import java.util.List;

import coza.opencollab.backbone.Entity;

/**
 * 
 * @author SW Genis
 *
 */
public class Group extends Entity {

    private List<String> userIds;

    public List<String> getUserIds() {
	if (userIds == null) {
	    userIds = new ArrayList<String>();
	}
	return userIds;
    }

}
