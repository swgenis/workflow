package za.ac.nwu.workflow.backbone.organization.service.impl;

import za.ac.nwu.workflow.backbone.organization.OrgUnit;
import za.ac.nwu.workflow.backbone.organization.OrgUnitMember;
import za.ac.nwu.workflow.backbone.organization.service.OrganizationService;
import za.ac.nwu.workflow.backbone.person.service.impl.PersonMockDataLoader;
import za.ac.nwu.workflow.backbone.type.service.TypeServiceConstants;

/**
 * 
 * @author SW Genis
 *
 */
public class OrganizationMockDataLoader {
	
	public static final String ORG_POTCH_ID = "org.campus.potch";
	public static final String ORG_IT_ID = "org.depart.it";
	public static final String ORG_HR_ID = "org.depart.hr";
	
	public static final String ORG_IT_BOB_ID = "org.depart.it.bob";
	public static final String ORG_IT_JOHN_ID = "org.depart.it.john";
	public static final String ORG_IT_CAROL_ID = "org.depart.it.carol";
	public static final String ORG_IT_JIRI_ID = "org.depart.it.jiri";
	public static final String ORG_HR_MARY_ID = "org.depart.hr.mary";

	private OrganizationService organizationService;
	
	public OrganizationMockDataLoader(OrganizationService organizationService){
		this.organizationService = organizationService;
	}

	public void loadData() throws Exception {
		addOrgUnit(ORG_POTCH_ID, "Potchefstroom Campus", null, TypeServiceConstants.TYPE_ORGUNIT_CAMPUS);
		addOrgUnit(ORG_IT_ID, "IT Department", ORG_POTCH_ID, TypeServiceConstants.TYPE_ORGUNIT_DEPARTMENT);
		addOrgUnitMember(ORG_IT_BOB_ID, ORG_IT_ID, PersonMockDataLoader.PERSON1_ID, TypeServiceConstants.TYPE_ORGUNITMEMBER_STAFF);
		addOrgUnitMember(ORG_IT_JOHN_ID, ORG_IT_ID, PersonMockDataLoader.PERSON1_ID, TypeServiceConstants.TYPE_ORGUNITMEMBER_STAFF);
		addOrgUnitMember(ORG_IT_CAROL_ID, ORG_IT_ID, PersonMockDataLoader.PERSON1_ID, TypeServiceConstants.TYPE_ORGUNITMEMBER_STAFF);
		addOrgUnitMember(ORG_IT_JIRI_ID, ORG_IT_ID, PersonMockDataLoader.PERSON1_ID, TypeServiceConstants.TYPE_ORGUNITMEMBER_MANAGER);
		addOrgUnit(ORG_HR_ID, "HR Department", ORG_POTCH_ID, TypeServiceConstants.TYPE_ORGUNIT_DEPARTMENT);
		addOrgUnitMember(ORG_HR_MARY_ID, ORG_HR_ID, PersonMockDataLoader.PERSON1_ID, TypeServiceConstants.TYPE_ORGUNITMEMBER_STAFF);
	}

	private void addOrgUnit(String id, String name, String parentOrgUnitId, String typeKey) throws Exception {
		OrgUnit orgUnit = new OrgUnit();
		orgUnit.setId(id);
		orgUnit.setName(name);
		orgUnit.setParentOrgUnitId(parentOrgUnitId);
		orgUnit.setTypeKey(typeKey);
		organizationService.insertOrgUnit(orgUnit);
	}
	
	private void addOrgUnitMember(String id, String orgId, String personId, String typeKey) throws Exception {
		OrgUnitMember orgUnitMember = new OrgUnitMember();
		orgUnitMember.setId(id);
		orgUnitMember.setOrgId(orgId);
		orgUnitMember.setPersonId(personId);
		orgUnitMember.setTypeKey(typeKey);
		organizationService.insertOrgUnitMember(orgUnitMember);
	}

}
