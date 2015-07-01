package coza.opencollab.backbone.identity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.kzac.common.dto.ContextInfo;
import org.kzac.core.person.dto.PersonInfo;
import org.kzac.core.person.service.PersonService;

import coza.opencollab.backbone.authorization.User;
import coza.opencollab.backbone.authorization.service.AuthorizationService;
import coza.opencollab.backbone.data.DataLoaderCallback;
import coza.opencollab.backbone.data.JsonDataLoader;
import coza.opencollab.backbone.qualifiers.MapService;

@ApplicationScoped
public class IdentityServiceFactory {

    @Inject
    @MapService
    AuthorizationService authorizationService;

    @Inject
    @MapService
    PersonService personService;

    @Produces
    public AuthorizationService produceAuthorizationService() {
	return authorizationService;
    }

    @Produces
    public PersonService producePersonService() {
	return personService;
    }

    @PostConstruct
    public void init() {
	createUerDataLoader(authorizationService).loadData("mock-user.json");
	createPersonDataLoader(personService).loadData("mock-person.json");
    }

    public static JsonDataLoader<User> createUerDataLoader(final AuthorizationService authorizationService) {
	JsonDataLoader<User> userLoader = new JsonDataLoader<User>(User.class);
	userLoader.setCallback(new DataLoaderCallback<User>() {

	    @Override
	    public void loadElement(User user) throws Exception {
		authorizationService.insertUser(user);

	    }
	});
	return userLoader;
    }

    public static JsonDataLoader<PersonInfo> createPersonDataLoader(final PersonService personService) {
	JsonDataLoader<PersonInfo> personLoader = new JsonDataLoader<PersonInfo>(PersonInfo.class);
	personLoader.setCallback(new DataLoaderCallback<PersonInfo>() {

	    @Override
	    public void loadElement(PersonInfo person) throws Exception {
		personService.createPerson(person.getTypeKey(), person, new ContextInfo());

	    }
	});
	return personLoader;
    }

}
