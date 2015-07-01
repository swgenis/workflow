package org.kzac.core.contact.service;

import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.kzac.common.dto.ContextInfo;
import org.kzac.common.dto.StatusInfo;
import org.kzac.common.dto.ValidationResultInfo;
import org.kzac.common.search.Criteria;
import org.kzac.core.contact.dto.AddressInfo;
import org.kzac.core.contact.dto.ContactInfo;
import org.kzac.exceptions.DataValidationErrorException;
import org.kzac.exceptions.DependentObjectsExistException;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;
import org.kzac.exceptions.ReadOnlyException;
import org.kzac.exceptions.VersionMismatchException;


@WebService(name = "ContactService", targetNamespace = ContactServiceNamespace.NAMESPACE)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)

public interface ContactService {

    /** 
     * Retrieves a single Address by Address Id.
     *
     * @param addressId the identifier for the address to be retrieved
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the Address requested
     * @throws DoesNotExistException addressId not found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException addressId or contextInfo is
     *         missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public AddressInfo getAddress(@WebParam(name = "addressId") String addressId, 
                                  @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a list of Addresses from a list of Address Ids. The
     * returned list may be in any order and if duplicates Ids are
     * supplied, a unique set may or may not be returned.
     *
     * @param addressIds a list of Address identifiers
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Addresses
     * @throws DoesNotExistException an addressId in the list not
     *         found
     * @throws InvalidParameterException contextInfo is invalid
     * @throws MissingParameterException addressIds, an Id in
     *         addressIds, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<AddressInfo> getAddressesByIds(@WebParam(name = "addressIds") List<String> addressIds, 
                                               @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a list of Address Ids by Address Type.
     *
     * @param addressTypeKey an identifier for an Address Type
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Address identifiers matching addressTypeKey
     *         or an empty list if none found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException addressTypeKey or contextInfo
     *         is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> getAddressIdsByType(@WebParam(name = "addressTypeKey") String addressTypeKey, 
                                            @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /**
     * Searches for Addresses based on the criteria and returns a list
     * of Address identifiers which match the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return list of Address Ids matching the criteria
     * @throws InvalidParameterException criteria or contextInfo is
     *         not valid
     * @throws MissingParameterException criteria or contextInfo is
     *         missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> searchForAddressIds(@WebParam(name = "criteria") Criteria criteria, 
                                            @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /**
     * Searches for Addresses based on the criteria and returns a list
     * of Addresses which match the search criteria.
     * 
     * @param criteria the search criteria
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return list of Addresses matching the criteria
     * @throws InvalidParameterException criteria or contextInfo is
     *         not valid
     * @throws MissingParameterException criteria or contextInfo is
     *         missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<AddressInfo> searchForAddresses(@WebParam(name = "criteria") Criteria criteria, 
                                                @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Validates an Address. Depending on the value of validationType,
     * this validation could be limited to tests on just the current
     * Address and its directly contained sub-objects or expanded to
     * perform all tests related to this Address. If an identifier is
     * present for the Address (and/or one of its contained
     * sub-objects) and a record is found for that identifier, the
     * validation checks if the Address can be updated to the new
     * values. If an identifier is not present or a record does not
     * exist, the validation checks if the object with the given data
     * can be created.
     *
     * @param validationTypeKey the identifier for the validation Type
     * @param addressTypeKey the identifier for the address Type
     * @param addressInfo the Address information to be validated
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of validation results or an empty list if
     *         validation succeeded
     * @throws DoesNotExistException validationTypeKey, or
     *         addressTypeKey is not found
     * @throws InvalidParameterException addressInfo or
     *         contextInfo is not valid
     * @throws MissingParameterException validationTypeKey,
     *         addressTypeKey, AddressInfo, or contextInfo is missing
     *         or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ValidationResultInfo> validateAddress(@WebParam(name = "validationTypeKey") String validationTypeKey, 
                                                      @WebParam(name = "addressTypeKey") String addressTypeKey, 
                                                      @WebParam(name = "addressInfo") AddressInfo addressInfo, 
                                                      @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Creates a new Address. The Address Id, Type, and Meta
     * information may not be set in the supplied data.
     *
     * @param addressTypeKey the identifier for the Type
     *        of the new Address
     * @param addressInfo the data with which to create
     *        the Address
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the new Address 
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException addressTypeKey does not exist or
     *         is not supported
     * @throws InvalidParameterException addressInfo or contextInfo is
     *         not valid
     * @throws MissingParameterException addressTypeKey, addressInfo
     *         or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information
     *         designated as read-only
     */
    public AddressInfo createAddress(@WebParam(name = "addressTypeKey") String addressTypeKey, 
                                     @WebParam(name = "addressInfo") AddressInfo addressInfo, 
                                     @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DataValidationErrorException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException, 
               ReadOnlyException;

    /** 
     * Updates an existing Address. The Address Id, Type, and Meta
     * information may not be changed.
     *
     * @param addressId the identifier for the Address to be updated
     * @param addressInfo the new data for the Address
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the updated Address
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException addressId not found
     * @throws InvalidParameterException addressInfo or contextInfo is
     *         not valid
     * @throws MissingParameterException addressId, addressInfo, or
     *         contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at changing information
     *         designated as read-only
     * @throws VersionMismatchException optimistic locking failure or
     *         the action was attempted on an out of date version
     */
    public AddressInfo updateAddress(@WebParam(name = "addressId") String addressId, 
                                     @WebParam(name = "addressInfo") AddressInfo addressInfo, 
                                     @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DataValidationErrorException, 
               DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException, 
               ReadOnlyException, 
               VersionMismatchException;

    /** 
     * Deletes an existing Address.
     *
     * @param addressId the identifier for the
     *        Address to be deleted
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the status of the delete operation. This must always be
     *         true.
     * @throws DoesNotExistException addressId not found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException addressId or
     *         contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public StatusInfo deleteAddress(@WebParam(name = "addressId") String addressId, 
                                    @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DependentObjectsExistException,
               DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a single Contact by Contact Id.
     *
     * @param contactId the identifier for the contact to be retrieved
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the Contact requested
     * @throws DoesNotExistException contactId not found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException contactId or contextInfo is
     *         missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public ContactInfo getContact(@WebParam(name = "contactId") String contactId, 
                                  @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a list of Contacts from a list of Contact Ids. The
     * returned list may be in any order and if duplicates Ids are
     * supplied, a unique set may or may not be returned.
     *
     * @param contactIds a list of Contact identifiers
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Contacts
     * @throws DoesNotExistException a contactId in the list not
     *         found
     * @throws InvalidParameterException contextInfo is invalid
     * @throws MissingParameterException contactIds, an Id in
     *         contactIds, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ContactInfo> getContactsByIds(@WebParam(name = "contactIds") List<String> contactIds, 
                                               @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a list of Contact Ids by Contact Type.
     *
     * @param contactTypeKey an identifier for a Contact Type
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Contact identifiers matching contactTypeKey
     *         or an empty list if none found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException contactTypeKey or contextInfo
     *         is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> getContactIdsByType(@WebParam(name = "contactTypeKey") String contactTypeKey, 
                                            @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;


    /** 
     * Retrieves a list of Contacts by Reference.
     *
     * @param referenceUri URI for the reference object
     * @param referenceId the identifier of the reference
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Contacts for the given reference, or an empty
     *         list if none found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException referenceUri, referenceId, or
     *         contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ContactInfo> getContactsByReference(@WebParam(name = "referenceUri") String referenceUri, 
                                                    @WebParam(name = "referenceId") String referenceId, 
                                                    @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a list of Contacts by Reference and Type.
     *
     * @param contactTypeKey a contact Type key
     * @param referenceUri URI for the reference object
     * @param referenceId the identifier of the reference
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Contacts for the given reference, or an empty
     *         list if none found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException contactTypeKey, referenceUri,
     *         referenceId, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ContactInfo> getContactsByTypeAndReference(@WebParam(name = "contactTypeKey") String contactTypeKey, 
                                                           @WebParam(name = "referenceUri") String referenceUri, 
                                                           @WebParam(name = "referenceId") String referenceId, 
                                                           @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a list of Contacts by Reference on Date. Contacts are
     * returned where the given date is within the effective date
     * range inclusive.
     *
     * @param referenceUri URI for the reference object
     * @param referenceId the identifier of the reference
     * @param date a date
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Contacts for the given reference, or an empty
     *         list if none found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException referenceUri, referenceId,
     *         date, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ContactInfo> getContactsByReferenceOnDate(@WebParam(name = "referenceUri") String referenceUri, 
                                                          @WebParam(name = "referenceId") String referenceId, 
                                                          @WebParam(name = "date") Date date, 
                                                          @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Retrieves a list of Contacts by Reference and Type on date.
     *
     * @param contactTypeKey a contact Type key
     * @param referenceUri URI for the reference object
     * @param referenceId the identifier of the reference
     * @param date a date
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of Contacts for the given reference, or an empty
     *         list if none found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException contactTypeKey, referenceUri,
     *         referenceId, date, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ContactInfo> getContactsByTypeAndReferenceOnDate(@WebParam(name = "contactTypeKey") String contactTypeKey, 
                                                                 @WebParam(name = "referenceUri") String referenceUri, 
                                                                 @WebParam(name = "referenceId") String referenceId, 
                                                                 @WebParam(name = "date") Date date, 
                                                                 @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    //// should be reverse query on this relationship //////

    /**
     * Searches for Contacts based on the criteria and returns a list
     * of Contact identifiers which match the search criteria.
     *
     * @param criteria the search criteria
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return list of Contact Ids matching the criteria
     * @throws InvalidParameterException criteria or contextInfo is
     *         not valid
     * @throws MissingParameterException criteria or contextInfo is
     *         missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<String> searchForContactIds(@WebParam(name = "criteria") Criteria criteria, 
                                            @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /**
     * Searches for Contacts based on the criteria and returns a list
     * of Contacts which match the search criteria.
     * 
     * @param criteria the search criteria
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return list of Contacts matching the criteria
     * @throws InvalidParameterException criteria or contextInfo is
     *         not valid
     * @throws MissingParameterException criteria or contextInfo is
     *         missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ContactInfo> searchForContacts(@WebParam(name = "criteria") Criteria criteria, 
                                                @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Validates a Contact. Depending on the value of validationType,
     * this validation could be limited to tests on just the current
     * Contact and its directly contained sub-objects or expanded to
     * perform all tests related to this Contact. If an identifier is
     * present for the Contact (and/or one of its contained
     * sub-objects) and a record is found for that identifier, the
     * validation checks if the Contact can be updated to the new
     * values. If an identifier is not present or a record does not
     * exist, the validation checks if the object with the given data
     * can be created.
     *
     * @param validationTypeKey the identifier for the validation Type
     * @param referenceUri the URI for the reference
     * @param referenceId the Id of the reference
     * @param addressId the Id of the Address
     * @param contactTypeKey the identifier for the contact Type
     * @param contactInfo the Contact information to be validated
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return a list of validation results or an empty list if
     *         validation succeeded
     * @throws DoesNotExistException validationTypeKey, referenceId,
     *         addressId, or contactTypeKey is not found
     * @throws InvalidParameterException contactInfo or
     *         contextInfo is not valid
     * @throws MissingParameterException validationTypeKey,
     *         referenceUri, referenceId, addressId, contactTypeKey,
     *         ContactInfo, or contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public List<ValidationResultInfo> validateContact(@WebParam(name = "validationTypeKey") String validationTypeKey, 
                                                      @WebParam(name = "referenceUri") String referenceUri, 
                                                      @WebParam(name = "referenceId") String referenceId, 
                                                      @WebParam(name = "addressId") String addressId, 
                                                      @WebParam(name = "contactTypeKey") String contactTypeKey, 
                                                      @WebParam(name = "contactInfo") ContactInfo contactInfo, 
                                                      @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;

    /** 
     * Creates a new Contact. The Contact Id, Type, and Meta
     * information may not be set in the supplied data.
     *
     * @param referenceUri the URI for the reference
     * @param referenceId the Id of the reference
     * @param addressId the Id of the Address
     * @param contactTypeKey the identifier for the Type
     *        of the new Contact
     * @param contactInfo the data with which to create
     *        the Contact
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the new Contact 
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException referenceId, addressId, or
     *         contactTypeKey does not exist or is not supported
     * @throws InvalidParameterException contactInfo or contextInfo is
     *         not valid
     * @throws MissingParameterException referenceUri, referenceId,
     *         addressId, contactTypeKey, contactInfo or contextInfo
     *         is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at supplying information
     *         designated as read-only
     */
    public ContactInfo createContact(@WebParam(name = "referenceUri") String referenceUri, 
                                     @WebParam(name = "referenceId") String referenceId, 
                                     @WebParam(name = "addressId") String addressId, 
                                     @WebParam(name = "contactTypeKey") String contactTypeKey, 
                                     @WebParam(name = "contactInfo") ContactInfo contactInfo, 
                                     @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DataValidationErrorException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException, 
               ReadOnlyException;

    /** 
     * Updates an existing Contact. The Contact Id, Type, and Meta
     * information may not be changed.
     *
     * @param contactId the identifier for the Contact to be updated
     * @param contactInfo the new data for the Contact
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the updated Contact
     * @throws DataValidationErrorException supplied data is invalid
     * @throws DoesNotExistException contactId not found
     * @throws InvalidParameterException contactInfo or contextInfo is
     *         not valid
     * @throws MissingParameterException contactId, contactInfo, or
     *         contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     * @throws ReadOnlyException an attempt at changing information
     *         designated as read-only
     * @throws VersionMismatchException optimistic locking failure or
     *         the action was attempted on an out of date version
     */
    public ContactInfo updateContact(@WebParam(name = "contactId") String contactId, 
                                     @WebParam(name = "contactInfo") ContactInfo contactInfo, 
                                     @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DataValidationErrorException, 
               DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException, 
               ReadOnlyException, 
               VersionMismatchException;

    /** 
     * Deletes an existing Contact.
     *
     * @param contactId the identifier for the
     *        Contact to be deleted
     * @param contextInfo information containing the principalId and
     *        locale information about the caller of service operation
     * @return the status of the delete operation. This must always be
     *         true.
     * @throws DependentObjectsExistException Contact cannot be
     *         removed due to a dependency
     * @throws DoesNotExistException contactId not found
     * @throws InvalidParameterException contextInfo is not valid
     * @throws MissingParameterException contactId or
     *         contextInfo is missing or null
     * @throws OperationFailedException unable to complete request
     * @throws PermissionDeniedException an authorization failure occurred
     */
    public StatusInfo deleteContact(@WebParam(name = "contactId") String contactId, 
                                    @WebParam(name = "contextInfo") ContextInfo contextInfo) 
        throws DependentObjectsExistException,
               DoesNotExistException, 
               InvalidParameterException, 
               MissingParameterException, 
               OperationFailedException, 
               PermissionDeniedException;
}
