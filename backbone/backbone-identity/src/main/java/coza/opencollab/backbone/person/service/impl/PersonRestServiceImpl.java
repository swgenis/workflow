package coza.opencollab.backbone.person.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import org.kzac.common.search.Criteria;
import org.kzac.common.search.Field;
import org.kzac.common.search.LogicalExpression;
import org.kzac.common.search.RelationalExpression;
import org.kzac.common.search.Value;
import org.kzac.core.person.dto.PersonInfo;
import org.kzac.core.person.service.PersonRestService;
import org.kzac.core.person.service.PersonService;
import org.kzac.exceptions.DoesNotExistException;
import org.kzac.exceptions.InvalidParameterException;
import org.kzac.exceptions.MissingParameterException;
import org.kzac.exceptions.OperationFailedException;
import org.kzac.exceptions.PermissionDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import coza.opencollab.backbone.AbstractBackboneRestService;

/**
 * 
 * @author SW Genis
 * 
 */

public class PersonRestServiceImpl extends AbstractBackboneRestService implements PersonRestService {

    private static final Logger logger = LoggerFactory.getLogger(PersonRestServiceImpl.class);

    @Inject
    private PersonService personService;

    @Override
    public List<PersonInfo> search(String name, String surname, SecurityContext context) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	logger.debug("Searching for a person " + name + " " + surname);

	RelationalExpression nameExpr = new RelationalExpression(new Field("name"), RelationalExpression.Operator.EQUALS,
		new Value(name));
	RelationalExpression surnameExpr = new RelationalExpression(new Field("surname"), RelationalExpression.Operator.EQUALS,
		new Value(surname));

	// Delegate to service to do the actual searching.
	Criteria criteria = new Criteria();
	criteria.setWhere(new LogicalExpression(nameExpr, LogicalExpression.Operator.AND, surnameExpr));
	List<PersonInfo> searchResult = personService.searchForPersons(criteria, this.getContextInfo(context));
	return searchResult;
    }

    @Override
    public PersonInfo getPerson(String personId, SecurityContext context) throws DoesNotExistException,
	    InvalidParameterException, MissingParameterException, OperationFailedException, PermissionDeniedException {
	return personService.getPerson(personId, this.getContextInfo(context));
    }

}
