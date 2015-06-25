package coza.opencollab.backbone.organization.service;

import java.util.List;

import coza.opencollab.backbone.organization.Group;
import coza.opencollab.backbone.organization.OrgUnit;
import coza.opencollab.backbone.organization.OrgUnitMember;

/**
 * CRUD service for the maintenance of the organization hierarchy. 
 * 
 * The organization hierarchy is used to store the relationships between
 * organizational units. The service can also be used toe determine supervisors 
 * and staff members for a specific department, campus or school. 
 * 
 * @author SW Genis
 * 
 */
public interface OrganizationService {

    /**
     * Retrieve the organizational unit for the given orgUnitId.
     * 
     * @param id
     * @return
     */
    public OrgUnit getOrgUnitById(String id);

    /**
     * Retrieve all child organization units that belong the given orgUnitId.
     * 
     * @param parentOrgUnitId
     * @return List<OrgUnit>
     */
    public List<OrgUnit> getOrgUnitsByParentId(String parentOrgUnitId);

    /**
     * 
     * @param orgUnit
     * @throws Exception
     */
    public void insertOrgUnit(OrgUnit orgUnit) throws Exception;

    /**
     * 
     * @param orgUnit
     * @throws Exception
     */
    public void updateOrgUnit(OrgUnit orgUnit) throws Exception;

    /**
     * 
     * @param id
     * @throws Exception
     */
    public void deleteOrgUnitById(String id) throws Exception;

    /**
     * 
     * @param name
     * @return
     * @throws Exception
     */
    public List<OrgUnit> searchOrgUnit(String name) throws Exception;

    /**
     * 
     * @param id
     * @return
     */
    public OrgUnitMember getOrgUnitMemberById(String id);

    /**
     * 
     * @param orgUnitId
     * @param typeKey
     * @return
     */
    public List<OrgUnitMember> getOrgUnitMembersByOrgIdAndType(String orgUnitId, String typeKey);

    /**
     * 
     * @param orgUnitMember
     * @throws Exception
     */
    public void insertOrgUnitMember(OrgUnitMember orgUnitMember) throws Exception;

    /**
     * 
     * @param orgUnitMember
     * @throws Exception
     */
    public void updateOrgUnitMember(OrgUnitMember orgUnitMember) throws Exception;

    /**
     * 
     * @param id
     * @throws Exception
     */
    public void deleteOrgUnitMemberById(String id) throws Exception;

    /**
     * 
     * @param orgUnitId
     * @param personId
     * @return
     * @throws Exception
     */
    public List<OrgUnitMember> searchOrgUnitMember(String orgUnitId, String personId) throws Exception;
    
    /**
     * 
     * @param groupId
     * @return
     */
    public Group getGroupById(String groupId);

    /**
     * 
     * @param group
     * @throws Exception
     */
    public void insertGroup(Group group) throws Exception;

    /**
     * 
     * @param group
     */
    public void updateGroup(Group group);

    /**
     * 
     * @param groupId
     */
    public void deleteGroup(String groupId);

    /**
     * 
     * @param userId
     * @return
     */
    public List<String> getGroupIdsForUser(String userId);

}
