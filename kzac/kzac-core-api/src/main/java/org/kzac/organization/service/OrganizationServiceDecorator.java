/*
 * Copyright 2010 The Kuali Foundation 
 *
 * Licensed under the Educational Community License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kzac.organization.service;

import org.kzac.common.dto.ContextInfo;
import org.kzac.common.dto.StatusInfo;
import org.kzac.common.dto.ValidationResultInfo;
import org.kzac.exceptions.DataValidationErrorException;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;
import org.kzac.exceptions.ReadOnlyException;
import org.kzac.exceptions.VersionMismatchException;
import org.kzac.organization.dto.OrgHierarchyInfo;
import org.kzac.organization.dto.OrgInfo;
import org.kzac.organization.dto.OrgOrgRelationInfo;
import org.kzac.organization.dto.OrgPersonRelationInfo;
import org.kzac.organization.dto.OrgPositionRestrictionInfo;
import org.kzac.organization.dto.OrgTreeInfo;
import org.kzac.type.dto.TypeInfo;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

/**
 * @author tom
 */

public class OrganizationServiceDecorator
    implements OrganizationService {

    private OrganizationService nextDecorator;

    public OrganizationService getNextDecorator() {
        return nextDecorator;
    }

    public void setNextDecorator(OrganizationService nextDecorator) {
        this.nextDecorator = nextDecorator;
    }

    @Override
    public OrgHierarchyInfo getOrgHierarchy(String orgHierarchyId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgHierarchy(orgHierarchyId, contextInfo);
    }

    @Override
    public List<OrgHierarchyInfo> getOrgHierarchiesByIds(List<String> orgHierarchyIds, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgHierarchiesByIds(orgHierarchyIds, contextInfo);
    }

    @Override
    public List<String> getOrgHierarchyIdsByType(String orgHierarchyTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgHierarchyIdsByType(orgHierarchyTypeKey, contextInfo);
    }

    @Override
    public List<OrgHierarchyInfo> getOrgHierarchies(ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgHierarchies(contextInfo);
    }

    @Override
    public List<TypeInfo> getOrgTypes(ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgTypes(contextInfo);
    }

    @Override
    public OrgInfo getOrg(String orgId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrg(orgId, contextInfo);
    }

    @Override
    public List<OrgInfo> getOrgsByIds(List<String> orgIds, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgsByIds(orgIds, contextInfo);
    }

    @Override
    public List<String> getOrgIdsByType(String orgTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgIdsByType(orgTypeKey, contextInfo);
    }

    @Override
    public List<String> searchForOrgIds(CriteriaQuery<OrgInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgIds(criteria, contextInfo);
    }

    @Override
    public List<OrgInfo> searchForOrgs(CriteriaQuery<OrgInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgs(criteria, contextInfo);
    }

    @Override
    public List<ValidationResultInfo> validateOrg(String validationTypeKey, String orgTypeKey, OrgInfo orgInfo, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().validateOrg(validationTypeKey, orgTypeKey, orgInfo, contextInfo);
    }

    @Override
    public OrgInfo createOrg(String orgTypeKey, OrgInfo orgInfo, ContextInfo contextInfo) 
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return getNextDecorator().createOrg(orgTypeKey, orgInfo, contextInfo);
    }

    @Override
    public OrgInfo updateOrg(String orgId, OrgInfo orgInfo, ContextInfo contextInfo) 
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return getNextDecorator().updateOrg(orgId, orgInfo, contextInfo);
    }

    @Override
    public StatusInfo deleteOrg(String orgId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().deleteOrg(orgId, contextInfo);
    }

    @Override
    public List<TypeInfo> getOrgOrgRelationTypes(ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationTypes(contextInfo);
    }

    @Override
    public List<TypeInfo> getOrgOrgRelationTypesForOrgType(String orgTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationTypesForOrgType(orgTypeKey, contextInfo);
    }

    @Override
    public TypeInfo getOrgOrgRelationTypeForOrgType(String orgTypeKey,ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationTypeForOrgType(orgTypeKey, contextInfo);
    }

    @Override
    public List<TypeInfo> getOrgOrgRelationTypesForOrgHierarchy(String orgHierarchyId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationTypesForOrgHierarchy(orgHierarchyId, contextInfo);
    }

    @Override
    public Boolean hasOrgOrgRelation(String orgId, String comparisonOrgId, String orgOrgRelationTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().hasOrgOrgRelation(orgId, comparisonOrgId, orgOrgRelationTypeKey, contextInfo);
    }

    @Override
    public OrgOrgRelationInfo getOrgOrgRelation(String orgOrgRelationId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelation(orgOrgRelationId, contextInfo);
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByIds(List<String> orgOrgRelationIds, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationsByIds(orgOrgRelationIds, contextInfo);
    }

    @Override
    public List<String> getOrgOrgRelationIdsByType(String orgOrgRelationTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationIdsByType(orgOrgRelationTypeKey, contextInfo);
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByOrg(String orgId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationsByOrg(orgId, contextInfo);
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByOrgs(String orgId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationsByOrgs(orgId, contextInfo);
    }

    @Override
    public List<OrgOrgRelationInfo> getOrgOrgRelationsByTypeAndOrg(String orgId, String orgOrgRelationTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgOrgRelationsByTypeAndOrg(orgId, orgOrgRelationTypeKey, contextInfo);
    }

    @Override
    public List<String> searchForOrgOrgRelationIds(CriteriaQuery<OrgOrgRelationInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgOrgRelationIds(criteria, contextInfo);
    }

    @Override
    public List<OrgOrgRelationInfo> searchForOrgOrgRelations(CriteriaQuery<OrgOrgRelationInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgOrgRelations(criteria, contextInfo);
    }

    @Override
    public List<ValidationResultInfo> validateOrgOrgRelation(String validationTypeKey, String orgId, String orgPeerId, String orgOrgRelationTypeKey, OrgOrgRelationInfo orgOrgRelationInfo, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().validateOrgOrgRelation(validationTypeKey, orgId, orgPeerId, orgOrgRelationTypeKey, orgOrgRelationInfo, contextInfo);
    }

    @Override
    public OrgOrgRelationInfo createOrgOrgRelation(String orgId, String orgPeerId, String orgOrgRelationTypeKey, OrgOrgRelationInfo orgOrgRelationInfo, ContextInfo contextInfo) 
	    throws DoesNotExistException, DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return getNextDecorator().createOrgOrgRelation(orgId, orgPeerId, orgOrgRelationTypeKey, orgOrgRelationInfo, contextInfo);
    }

    @Override
    public OrgOrgRelationInfo updateOrgOrgRelation(String orgOrgRelationId, OrgOrgRelationInfo orgOrgRelationInfo, ContextInfo contextInfo) 
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return getNextDecorator().updateOrgOrgRelation(orgOrgRelationId, orgOrgRelationInfo, contextInfo);
    }

    @Override
    public StatusInfo deleteOrgOrgRelation(String orgOrgRelationId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().deleteOrgOrgRelation(orgOrgRelationId, contextInfo);
    }

    @Override
    public List<TypeInfo> getOrgPersonRelationTypes(ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationTypes(contextInfo);
    }

    @Override
    public List<TypeInfo> getOrgPersonRelationTypesForOrgType(String orgTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationTypesForOrgType(orgTypeKey, contextInfo);
    }

    @Override
    public Boolean hasOrgPersonRelation(String orgId, String personId, String orgPersonRelationTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().hasOrgPersonRelation(orgId, personId, orgPersonRelationTypeKey, contextInfo);
    }

    @Override
    public OrgPersonRelationInfo getOrgPersonRelation(String orgPersonRelationId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelation(orgPersonRelationId, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByIds(List<String> orgPersonRelationIds, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationsByIds(orgPersonRelationIds, contextInfo);
    }

    @Override
    public List<String> getOrgPersonRelationIdsByType(String orgPersonRelationTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationIdsByType(orgPersonRelationTypeKey, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByOrg(String orgId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationsByOrg(orgId, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndOrg(String orgPersonRelationTypeKey, String orgId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationsByTypeAndOrg(orgPersonRelationTypeKey, orgId, contextInfo);
    }

    @Override
    public OrgPersonRelationInfo getOrgPersonRelationByTypeAndOrg(String orgPersonRelationTypeKey, String orgId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationByTypeAndOrg(orgPersonRelationTypeKey, orgId, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByPerson(String personId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationsByPerson(personId, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndPerson(String orgPersonRelationTypeKey, String personId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationsByTypeAndPerson(orgPersonRelationTypeKey, personId, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByOrgAndPerson(String orgId, String personId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationsByOrgAndPerson(orgId, personId, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> getOrgPersonRelationsByTypeAndOrgAndPerson(String orgPersonRelationTypeKey, String orgId, String personId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPersonRelationsByTypeAndOrgAndPerson(orgPersonRelationTypeKey, orgId, personId, contextInfo);
    }

    @Override
    public List<String> searchForOrgPersonRelationIds(CriteriaQuery<OrgPersonRelationInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgPersonRelationIds(criteria, contextInfo);
    }

    @Override
    public List<OrgPersonRelationInfo> searchForOrgPersonRelations(CriteriaQuery<OrgPersonRelationInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgPersonRelations(criteria, contextInfo);
    }

    @Override
    public List<ValidationResultInfo> validateOrgPersonRelation(String validationTypeKey, String orgId, String personId, String orgPersonRelationTypeKey, OrgPersonRelationInfo orgPersonRelationInfo, 
	    ContextInfo contextInfo) 
		    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().validateOrgPersonRelation(validationTypeKey, orgId, personId, orgPersonRelationTypeKey, orgPersonRelationInfo, contextInfo);
    }

    @Override
    public OrgPersonRelationInfo createOrgPersonRelation(String orgId, String personId, String orgPersonRelationTypeKey, OrgPersonRelationInfo orgPersonRelationInfo, ContextInfo contextInfo) 
	    throws DoesNotExistException, DataValidationErrorException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return getNextDecorator().createOrgPersonRelation(orgId, personId, orgPersonRelationTypeKey, orgPersonRelationInfo, contextInfo);
    }

    @Override
    public OrgPersonRelationInfo updateOrgPersonRelation(String orgPersonRelationId, OrgPersonRelationInfo orgPersonRelationInfo, ContextInfo contextInfo) 
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, VersionMismatchException {
        return getNextDecorator().updateOrgPersonRelation(orgPersonRelationId, orgPersonRelationInfo, contextInfo);
    }

    @Override
    public StatusInfo deleteOrgPersonRelation(String orgPersonRelationId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().deleteOrgPersonRelation(orgPersonRelationId, contextInfo);
    }

    @Override
    public OrgPositionRestrictionInfo getOrgPositionRestriction(String orgPositionRestrictionId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPositionRestriction(orgPositionRestrictionId, contextInfo);
    }

    @Override
    public List<OrgPositionRestrictionInfo> getOrgPositionRestrictionsByIds(List<String> orgPositionRestrictionIds, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPositionRestrictionsByIds(orgPositionRestrictionIds, contextInfo);
    }

    @Override
    public List<String> getOrgPositionRestrictionIdsByType(String orgPersonRelationTypeKey, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPositionRestrictionIdsByType(orgPersonRelationTypeKey, contextInfo);
    }

    @Override
    public List<String> getOrgPositionRestrictionIdsByOrg(String orgId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgPositionRestrictionIdsByOrg(orgId, contextInfo);
    }

    @Override
    public List<String> searchForOrgPositionRestrictionIds(CriteriaQuery<OrgPositionRestrictionInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgPositionRestrictionIds(criteria, contextInfo);
    }

    @Override
    public List<OrgPositionRestrictionInfo> searchForOrgPositionRestrictions(CriteriaQuery<OrgPositionRestrictionInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgPositionRestrictions(criteria, contextInfo);
    }

    @Override
    public List<ValidationResultInfo> validateOrgPositionRestriction(String validationTypeKey, String orgId, String orgPersonRelationTypeKey, OrgPositionRestrictionInfo orgPositionRestrictionInfo, 
	    ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().validateOrgPositionRestriction(validationTypeKey, orgId, orgPersonRelationTypeKey, orgPositionRestrictionInfo, contextInfo);
    }

    @Override
    public OrgPositionRestrictionInfo createOrgPositionRestriction(String orgId, String orgPersonRelationTypeKey, OrgPositionRestrictionInfo orgPositionRestrictionInfo, ContextInfo contextInfo) 
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
        return getNextDecorator().createOrgPositionRestriction(orgId, orgPersonRelationTypeKey, orgPositionRestrictionInfo, contextInfo);
    }

    @Override
    public OrgPositionRestrictionInfo updateOrgPositionRestriction(String orgPositionRestrictionId, OrgPositionRestrictionInfo orgPositionRestrictionInfo, ContextInfo contextInfo) 
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException, 
	    VersionMismatchException {
        return getNextDecorator().updateOrgPositionRestriction(orgPositionRestrictionId, orgPositionRestrictionInfo, contextInfo);
    }

    @Override
    public StatusInfo deleteOrgPositionRestriction(String orgPositionRestrictionId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().deleteOrgPositionRestriction(orgPositionRestrictionId, contextInfo);
    }
                                                   
    @Override
    public Boolean isDescendant(String orgId, String descendantOrgId, String orgHierarchyId, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().isDescendant(orgId, descendantOrgId, orgHierarchyId, contextInfo);
    }

    @Override
    public List<String> getAllDescendants(String orgId, String orgHierarchyId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getAllDescendants(orgId, orgHierarchyId, contextInfo);
    }

    @Override
    public List<String> getAllAncestors(String orgId, String orgHierarchyId, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getAllAncestors(orgId, orgHierarchyId, contextInfo);
    }

    @Override
    public List<OrgTreeInfo> getOrgTree(String rootOrgId, String orgHierarchyId, int maxLevels, ContextInfo contextInfo) 
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().getOrgTree(rootOrgId, orgHierarchyId, maxLevels, contextInfo);
    }

    @Override
    public List<String> searchForOrgHierarchyIds(CriteriaQuery<OrgHierarchyInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgHierarchyIds(criteria, contextInfo);
    }

    @Override
    public List<OrgHierarchyInfo> searchForOrgHierarchies(CriteriaQuery<OrgHierarchyInfo> criteria, ContextInfo contextInfo) 
	    throws InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
        return getNextDecorator().searchForOrgHierarchies(criteria, contextInfo);
    }

}
