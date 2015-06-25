package coza.opencollab.backbone.organization;

import coza.opencollab.backbone.Entity;

/**
 * 
 * @author SW Genis
 * 
 */
public class OrgUnitMember extends Entity {

    private String orgId;

    private String userId;

    private String typeKey;

    public String getOrgId() {
	return orgId;
    }

    public void setOrgId(String orgId) {
	this.orgId = orgId;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getTypeKey() {
	return typeKey;
    }

    public void setTypeKey(String typeKey) {
	this.typeKey = typeKey;
    }

}
