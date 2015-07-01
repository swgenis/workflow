package za.ac.nwu.workflow.person.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.kuali.rice.kim.api.identity.entity.EntityDefault;
import org.kuali.rice.par.impl.identity.EmbeddedIdentityServiceImpl;
import org.kuali.rice.par.impl.identity.repository.PartyRepositoryImpl;
import org.kzac.common.dto.ContextInfo;
import org.kzac.common.dto.StatusInfo;
import org.kzac.common.dto.ValidationResultInfo;
import org.kzac.common.search.Criteria;
import org.kzac.core.person.dto.PersonAffiliationInfo;
import org.kzac.core.person.dto.PersonBioDemographicsInfo;
import org.kzac.core.person.dto.PersonIdentifierInfo;
import org.kzac.core.person.dto.PersonInfo;
import org.kzac.core.person.dto.PersonNameInfo;
import org.kzac.core.person.service.PersonService;
import org.kzac.exceptions.DataValidationErrorException;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;
import org.kzac.exceptions.ReadOnlyException;
import org.kzac.exceptions.VersionMismatchException;

import za.ac.nwu.workflow.PGSMSService;
import coza.opencollab.backbone.ConfigurationProperty;

@PGSMSService
public class PersonServiceKimImpl implements PersonService {

    private EmbeddedIdentityServiceImpl identityService;
    
    @Inject
    private PersonAssembler assembler;

    @Inject
    @ConfigurationProperty(value = "kim.datasource.url")
    private String url;
    
    @Inject
    @ConfigurationProperty(value = "kim.datasource.username")
    private String username;
    
    @Inject
    @ConfigurationProperty(value = "kim.datasource.password")
    private String password;
    
    @Inject
    @ConfigurationProperty(value = "kim.datasource.driverClassName")
    private String driverClassName;

    @PostConstruct
    private void initilize() {
	identityService = new EmbeddedIdentityServiceImpl();
	PartyRepositoryImpl partyRepository = new PartyRepositoryImpl();
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setUrl(url);
	dataSource.setUsername(username);
	dataSource.setPassword(password);
	dataSource.setDriverClassName(driverClassName);
	partyRepository.setDataSource(dataSource);
	identityService.setPartyRepository(partyRepository);

    }

    @Override
    public PersonInfo getPerson(String personId, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	EntityDefault entityDefault = identityService.getEntityDefault(personId);
	return assembler.assemblePerson(entityDefault);
    }

    @Override
    public List<PersonInfo> getPersonsByIds(List<String> personIds, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> getPersonIdsByType(String personTypeKey, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> searchForPersonIds(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonInfo> searchForPersons(Criteria criteria, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ValidationResultInfo> validatePerson(String validationTypeKey, String personTypeKey,
	    PersonInfo personInfo, ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonInfo createPerson(String personTypeKey, PersonInfo personInfo, ContextInfo contextInfo)
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonInfo updatePerson(String personId, PersonInfo personInfo, ContextInfo contextInfo)
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException,
	    VersionMismatchException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public StatusInfo deletePerson(String personId, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonNameInfo getPersonName(String personNameId, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonNameInfo> getPersonNamesByIds(List<String> personNameIds, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> getPersonNameIdsByType(String personNameTypeKey, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> searchForPersonNameIds(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonNameInfo> searchForPersonNames(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ValidationResultInfo> validatePersonName(String validationTypeKey, String personNameTypeKey,
	    String personId, PersonNameInfo personNameInfo, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonNameInfo createPersonName(String personNameTypeKey, String personId, PersonNameInfo personNameInfo,
	    ContextInfo contextInfo) throws DataValidationErrorException, DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException,
	    ReadOnlyException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonNameInfo updatePersonName(String personNameId, PersonNameInfo personNameInfo, ContextInfo contextInfo)
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException,
	    VersionMismatchException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public StatusInfo deletePersonName(String personNameId, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonNameInfo> getPersonNamesByPerson(String personId, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonIdentifierInfo getPersonIdentifier(String personIdentifierId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonIdentifierInfo> getPersonIdentifiersByIds(List<String> personIdentifierIds,
	    ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> getPersonIdentifierIdsByType(String personIdentifierTypeKey, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> searchForPersonIdentifierIds(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonIdentifierInfo> searchForPersonIdentifiers(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ValidationResultInfo> validatePersonIdentifier(String validationTypeKey,
	    String personIdentifierTypeKey, String personId, PersonIdentifierInfo personIdentifierInfo,
	    ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonIdentifierInfo createPersonIdentifier(String personIdentifierTypeKey, String personId,
	    PersonIdentifierInfo personIdentifierInfo, ContextInfo contextInfo) throws DataValidationErrorException,
	    DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException, ReadOnlyException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonIdentifierInfo updatePersonIdentifier(String personIdentifierId,
	    PersonIdentifierInfo personIdentifierInfo, ContextInfo contextInfo) throws DataValidationErrorException,
	    DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException, ReadOnlyException, VersionMismatchException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public StatusInfo deletePersonIdentifier(String personIdentifierId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonIdentifierInfo> getPersonIdentifiersByPerson(String personId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonIdentifierInfo> getPersonIdentifiersByIdentifier(String personIdentifierTypeKey,
	    String identifier, ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonBioDemographicsInfo getPersonBioDemographics(String personBioDemographicsId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonBioDemographicsInfo> getPersonBioDemographicsByIds(List<String> personBioDemographicsIds,
	    ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> getPersonBioDemographicsIdsByType(String personIdentifierTypeKey, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> searchForPersonBioDemographicsIds(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonBioDemographicsInfo> searchForPersonBioDemographics(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ValidationResultInfo> validatePersonBioDemographics(String validationTypeKey,
	    String personIdentifierTypeKey, String personId, PersonBioDemographicsInfo personBioDemographicsInfo,
	    ContextInfo contextInfo) throws InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonBioDemographicsInfo createPersonBioDemographics(String personIdentifierTypeKey, String personId,
	    PersonBioDemographicsInfo personBioDemographicsInfo, ContextInfo contextInfo)
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonBioDemographicsInfo updatePersonBioDemographics(String personBioDemographicsId,
	    PersonBioDemographicsInfo personBioDemographicsInfo, ContextInfo contextInfo)
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException,
	    VersionMismatchException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public StatusInfo deletePersonBioDemographics(String personBioDemographicsId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonBioDemographicsInfo getPersonBioDemographicsByPerson(String personId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonAffiliationInfo getPersonAffiliation(String personAffiliationId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonAffiliationInfo> getPersonAffiliationsByIds(List<String> personAffiliationIds,
	    ContextInfo contextInfo) throws DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> getPersonAffiliationIdsByType(String personAffiliationTypeKey, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> searchForPersonAffiliationIds(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonAffiliationInfo> searchForPersonAffiliations(Criteria criteria, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ValidationResultInfo> validatePersonAffiliation(String validationTypeKey,
	    String personAffiliationTypeKey, String personId, String organizationId,
	    PersonAffiliationInfo personAffiliationInfo, ContextInfo contextInfo) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonAffiliationInfo createPersonAffiliation(String personAffiliationTypeKey, String personId,
	    String organizationId, PersonAffiliationInfo personAffiliationInfo, ContextInfo contextInfo)
	    throws DataValidationErrorException, DoesNotExistException, InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException, ReadOnlyException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonAffiliationInfo updatePersonAffiliation(String personAffiliationId,
	    PersonAffiliationInfo personAffiliationInfo, ContextInfo contextInfo) throws DataValidationErrorException,
	    DoesNotExistException, InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException, ReadOnlyException, VersionMismatchException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public StatusInfo deletePersonAffiliation(String personAffiliationId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonAffiliationInfo> getPersonAffiliationsByPerson(String personId, ContextInfo contextInfo)
	    throws DoesNotExistException, InvalidParameterException, MissingParameterException,
	    OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<PersonInfo> getActivePeopleMatchingNameFragmentAndAffiliation(String nameFragment,
	    String personAffiliationTypeKey, String organizationId, ContextInfo contextInfo)
	    throws InvalidParameterException, MissingParameterException, OperationFailedException,
	    PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getInstitutionalAffiliationOrganizationId(ContextInfo contextInfo) throws InvalidParameterException,
	    MissingParameterException, OperationFailedException, PermissionDeniedException {
	// TODO Auto-generated method stub
	return null;
    }

}
