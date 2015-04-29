package za.ac.nwu.workflow.backbone.organization.service;

import java.util.List;

import za.ac.nwu.workflow.backbone.organization.OrgUnit;
import za.ac.nwu.workflow.backbone.organization.OrgUnitMember;

public interface OrganizationService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public OrgUnit getOrgUnitById(String id);
	
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

}
