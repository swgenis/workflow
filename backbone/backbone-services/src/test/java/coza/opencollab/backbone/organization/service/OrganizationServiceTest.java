package coza.opencollab.backbone.organization.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import coza.opencollab.backbone.organization.Group;
import coza.opencollab.backbone.organization.OrgUnit;
import coza.opencollab.backbone.organization.OrgUnitMember;
import coza.opencollab.backbone.organization.service.impl.OrganizationServiceMapImpl;
import coza.opencollab.backbone.qualifiers.MapService;

@RunWith(Arquillian.class)
public class OrganizationServiceTest {

    @Inject
    @MapService
    private OrganizationService organizationService;

    @Deployment
    public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class)
		.addClass(OrganizationServiceMapImpl.class)
		.addClass(OrganizationServiceMapImpl.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testGetOrgUnitById(String id) {
	assertNotNull(organizationService);
	// TODO: implement test
    }

    @Test
    public void testGetOrgUnitsByParentId(String parentOrgUnitId) {
	// TODO: implement test
    }

    @Test
    public void testInsertOrgUnit(OrgUnit orgUnit) {
	// TODO: implement test
    }

    @Test
    public void testUpdateOrgUnit(OrgUnit orgUnit) {
	// TODO: implement test
    }

    @Test
    public void testDeleteOrgUnitById(String id) {
	// TODO: implement test
    }

    @Test
    public void testSearchOrgUnit(String name) {
	// TODO: implement test
    }

    @Test
    public void testGetOrgUnitMemberById(String id) {
	// TODO: implement test
    }

    @Test
    public void testGetOrgUnitMembersByOrgIdAndType(String orgUnitId, String typeKey) {
	// TODO: implement test
    }

    @Test
    public void testInsertOrgUnitMember(OrgUnitMember orgUnitMember) {
	// TODO: implement test
    }

    @Test
    public void testUpdateOrgUnitMember(OrgUnitMember orgUnitMember) {
	// TODO: implement test
    }

    @Test
    public void testDeleteOrgUnitMemberById(String id) {
	// TODO: implement test
    }

    @Test
    public void testSearchOrgUnitMember(String orgUnitId, String personId) {
	// TODO: implement test
    }

    @Test
    public void testGetGroupById(String groupId) {
	// TODO: implement test
    }

    @Test
    public void testInsertGroup(Group group) {
	// TODO: implement test
    }

    @Test
    public void testUpdateGroup(Group group) {
	// TODO: implement test
    }

    @Test
    public void testDeleteGroup(String groupId) {
	// TODO: implement test
    }

    @Test
    public void testGetGroupIdsForUser(String userId) {
	// TODO: implement test
    }

}
