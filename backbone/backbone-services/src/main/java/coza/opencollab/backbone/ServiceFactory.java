package coza.opencollab.backbone;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import coza.opencollab.backbone.authorization.User;
import coza.opencollab.backbone.authorization.service.AuthorizationService;
import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.data.DataLoaderCallback;
import coza.opencollab.backbone.data.JsonDataLoader;
import coza.opencollab.backbone.organization.service.OrganizationService;
import coza.opencollab.backbone.person.Person;
import coza.opencollab.backbone.person.service.PersonService;
import coza.opencollab.backbone.qualifiers.MapService;
import coza.opencollab.backbone.type.service.TypeService;

@ApplicationScoped
public class ServiceFactory {

    @Inject
    @MapService
    AuthorizationService authorizationService;

    @Inject
    @MapService
    OrganizationService organizationService;

    @Inject
    @MapService
    PersonService personService;

    @Inject
    @MapService
    TypeService typeService;

    @Inject
    @MapService
    ConfigurationService configurationService;

    @PostConstruct
    public void init() {
	JsonDataLoader<User> userLoader = getUerDataLoader();
	userLoader.loadData("mock-user.json");

	JsonDataLoader<Person> personLoader = getPersonDataLoader();
	personLoader.loadData("mock-person.json");
    }

    @Produces
    public AuthorizationService produceAuthorizationService() {
	return authorizationService;
    }

    @Produces
    public OrganizationService produceOrganizationService() {
	return organizationService;
    }

    @Produces
    public PersonService producePersonService() {
	return personService;
    }

    @Produces
    public TypeService produceTypeService() {
	return typeService;
    }

    @Produces
    public ConfigurationService produceConfigurationService() {
	return configurationService;
    }

    private JsonDataLoader<User> getUerDataLoader() {
	JsonDataLoader<User> userLoader = new JsonDataLoader<User>(User.class);
	userLoader.setCallback(new DataLoaderCallback<User>() {

	    @Override
	    public void loadElement(User t) throws Exception {
		authorizationService.insertUser(t);

	    }
	});
	return userLoader;
    }

    private JsonDataLoader<Person> getPersonDataLoader() {
	JsonDataLoader<Person> personLoader = new JsonDataLoader<Person>(Person.class);
	personLoader.setCallback(new DataLoaderCallback<Person>() {

	    @Override
	    public void loadElement(Person t) throws Exception {
		personService.insertPerson(t);

	    }
	});
	return personLoader;
    }

}
