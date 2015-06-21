package za.ac.nwu.workflow.person.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.kuali.rice.kim.api.identity.entity.EntityDefault;
import org.kuali.rice.par.impl.identity.EmbeddedIdentityServiceImpl;
import org.kuali.rice.par.impl.identity.repository.PartyRepositoryImpl;

import za.ac.nwu.workflow.ShawaService;
import coza.opencollab.backbone.ConfigurationProperty;
import coza.opencollab.backbone.person.Person;
import coza.opencollab.backbone.person.service.PersonService;

@ShawaService
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
    public Person getPersonById(String id) {
	EntityDefault entityDefault = identityService.getEntityDefault(id);
	return assembler.assemblePerson(entityDefault);
    }

    @Override
    public void insertPerson(Person person) throws Exception {
	// TODO Auto-generated method stub

    }

    @Override
    public void updatePerson(Person person) throws Exception {
	// TODO Auto-generated method stub

    }

    @Override
    public void deletePersonById(String key) throws Exception {
	// TODO Auto-generated method stub

    }

    @Override
    public List<Person> searchPerson(String name, String surname) throws Exception {
	// TODO Auto-generated method stub
	return null;
    }

}
