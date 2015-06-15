package coza.opencollab.backbone.organization;

import coza.opencollab.backbone.Entity;

/**
 * 
 * @author SW Genis
 *
 */
public class OrgUnit extends Entity {

    private String parentOrgUnitId;

    private String name;

    private String typeKey;

    public String getParentOrgUnitId() {
	return parentOrgUnitId;
    }

    public void setParentOrgUnitId(String parentOrgUnitId) {
	this.parentOrgUnitId = parentOrgUnitId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getTypeKey() {
	return typeKey;
    }

    public void setTypeKey(String typeKey) {
	this.typeKey = typeKey;
    }

}
