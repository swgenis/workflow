package za.ac.nwu.workflow.backbone.organization;

import za.ac.nwu.workflow.backbone.Entity;

public class OrgUnitMember extends Entity {
	
	private String orgId;
	
	private String personId;
	
	private String typeKey;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getTypeKey() {
		return typeKey;
	}

	public void setTypeKey(String typeKey) {
		this.typeKey = typeKey;
	}

}
