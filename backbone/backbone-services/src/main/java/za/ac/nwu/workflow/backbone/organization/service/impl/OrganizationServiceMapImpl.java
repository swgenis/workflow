package za.ac.nwu.workflow.backbone.organization.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import za.ac.nwu.backbone.qualifiers.MapService;
import za.ac.nwu.workflow.backbone.organization.Group;
import za.ac.nwu.workflow.backbone.organization.OrgUnit;
import za.ac.nwu.workflow.backbone.organization.OrgUnitMember;
import za.ac.nwu.workflow.backbone.organization.service.OrganizationService;

/**
 * A map based implementation of the OrganizationService.
 * 
 * This class is a singleton to force the application server not to create more
 * than one instance of the service. A non-map based service should not be a
 * singleton.
 * 
 * @author SW Genis
 * 
 */
@MapService
@Singleton
public class OrganizationServiceMapImpl implements OrganizationService {

    private Map<String, OrgUnit> orgUnits = new HashMap<String, OrgUnit>();
    private Map<String, OrgUnitMember> orgUnitMembers = new HashMap<String, OrgUnitMember>();
    private Map<String, Group> groups = new HashMap<String, Group>();

    @PostConstruct
    public void initialize() throws Exception {
	OrganizationMockDataLoader dataLoader = new OrganizationMockDataLoader(this);
	try {
	    dataLoader.loadData();
	} catch (Exception e) {
	    throw new Exception("Unable to load data for OrganizationServiceMapImpl", e);
	}
    }

    @Override
    public OrgUnit getOrgUnitById(String id) {
	if (orgUnits.containsKey(id)) {
	    return orgUnits.get(id);
	}
	return null;
    }

    @Override
    public List<OrgUnit> getOrgUnitsByParentId(String parentOrgUnitId) {
	List<OrgUnit> searchResults = new ArrayList<OrgUnit>();
	for (OrgUnit orgUnit : orgUnits.values()) {
	    if (orgUnit.getParentOrgUnitId().equalsIgnoreCase(parentOrgUnitId)) {
		searchResults.add(orgUnit);
	    }
	}
	return searchResults;
    }

    @Override
    public void insertOrgUnit(OrgUnit orgUnit) throws Exception {
	if (orgUnits.containsKey(orgUnit.getId())) {
	    throw new Exception("OrgUnit already exists for id " + orgUnit.getId());
	}
	orgUnits.put(orgUnit.getId(), orgUnit);
    }

    @Override
    public void updateOrgUnit(OrgUnit orgUnit) throws Exception {
	if (!orgUnits.containsKey(orgUnit.getId())) {
	    throw new Exception("OrgUnit does not exist for id " + orgUnit.getId());
	}
	orgUnits.put(orgUnit.getId(), orgUnit);
    }

    @Override
    public void deleteOrgUnitById(String id) throws Exception {
	if (!orgUnits.containsKey(id)) {
	    throw new Exception("OrgUnit does not exist for id " + id);
	}
	orgUnits.remove(id);
    }

    @Override
    public List<OrgUnit> searchOrgUnit(String name) throws Exception {
	List<OrgUnit> searchResults = new ArrayList<OrgUnit>();
	for (OrgUnit orgUnit : orgUnits.values()) {
	    if (orgUnit.getName().equalsIgnoreCase(name)) {
		searchResults.add(orgUnit);
	    }
	}
	return searchResults;
    }

    @Override
    public OrgUnitMember getOrgUnitMemberById(String id) {
	if (orgUnitMembers.containsKey(id)) {
	    return orgUnitMembers.get(id);
	}
	return null;
    }

    @Override
    public List<OrgUnitMember> getOrgUnitMembersByOrgIdAndType(String orgUnitId, String typeKey) {
	List<OrgUnitMember> searchResults = new ArrayList<OrgUnitMember>();
	for (OrgUnitMember orgUnitMember : orgUnitMembers.values()) {
	    if (orgUnitMember.getOrgId().equalsIgnoreCase(orgUnitId) && (orgUnitMember.getTypeKey().equals(typeKey))) {
		searchResults.add(orgUnitMember);
	    }
	}
	return searchResults;
    }

    @Override
    public void insertOrgUnitMember(OrgUnitMember orgUnitMember) throws Exception {
	if (orgUnitMembers.containsKey(orgUnitMember.getId())) {
	    throw new Exception("OrgUnitMember already exists for id " + orgUnitMember.getId());
	}
	orgUnitMembers.put(orgUnitMember.getId(), orgUnitMember);
    }

    @Override
    public void updateOrgUnitMember(OrgUnitMember orgUnitMember) throws Exception {
	if (!orgUnitMembers.containsKey(orgUnitMember.getId())) {
	    throw new Exception("OrgUnitMember does not exist for id " + orgUnitMember.getId());
	}
	orgUnitMembers.put(orgUnitMember.getId(), orgUnitMember);
    }

    @Override
    public void deleteOrgUnitMemberById(String id) throws Exception {
	if (!orgUnitMembers.containsKey(id)) {
	    throw new Exception("OrgUnitMember does not exist for id " + id);
	}
	orgUnitMembers.remove(id);
    }

    @Override
    public List<OrgUnitMember> searchOrgUnitMember(String orgUnitId, String userId) throws Exception {
	List<OrgUnitMember> searchResults = new ArrayList<OrgUnitMember>();
	for (OrgUnitMember orgUnitMember : orgUnitMembers.values()) {
	    if ((orgUnitId != null) && (!orgUnitMember.getOrgId().equals(orgUnitId))) {
		continue;
	    }
	    if ((userId != null) && (!orgUnitMember.getUserId().equals(userId))) {
		continue;
	    }
	    searchResults.add(orgUnitMember);
	}
	return searchResults;
    }

    @Override
    public Group getGroupById(String groupId) {
	if (groups.containsKey(groupId)) {
	    return groups.get(groupId);
	}
	return null;
    }

    @Override
    public void insertGroup(Group group) throws Exception {
	if (groups.containsKey(group.getId())) {
	    throw new Exception("Group already exists for id " + group.getId());
	}
	groups.put(group.getId(), group);
    }

    @Override
    public void updateGroup(Group group) {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteGroup(String groupId) {
	// TODO Auto-generated method stub

    }

    public List<String> getGroupIdsForUser(String userId) {
	List<String> groupIds = new ArrayList<String>();
	for (Group group : groups.values()) {
	    if (isUserInGroup(userId, group)) {
		groupIds.add(group.getId());
	    }
	}
	return groupIds;
    }

    private boolean isUserInGroup(String userId, Group group) {
	// If list is empty, return false.
	if (group.getUserIds().isEmpty()) {
	    return false;
	}

	if (group.getUserIds().contains(userId)){
	    return true;
	}
	return false;
    }

}
