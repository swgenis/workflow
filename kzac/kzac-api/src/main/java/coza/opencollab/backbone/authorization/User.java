package coza.opencollab.backbone.authorization;

import coza.opencollab.backbone.Entity;

/**
 * 
 * @author SW Genis
 *
 */
public class User extends Entity {

    private String personId;

    public String getPersonId() {
	return personId;
    }

    public void setPersonId(String personId) {
	this.personId = personId;
    }

}
