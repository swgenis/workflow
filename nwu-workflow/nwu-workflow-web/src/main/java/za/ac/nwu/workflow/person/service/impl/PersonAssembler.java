package za.ac.nwu.workflow.person.service.impl;

import org.kuali.rice.kim.api.identity.entity.EntityDefault;

import coza.opencollab.backbone.person.Person;

public class PersonAssembler {
    
    public Person assemblePerson(EntityDefault kimEntity) {
	Person person = new Person();
	person.setId(kimEntity.getEntityId());
	person.setName(kimEntity.getName().getFirstNameUnmasked());
	person.setSurname(kimEntity.getName().getLastNameUnmasked());
	person.setEmail(kimEntity.getEntityTypeContactInfos().get(0).getDefaultEmailAddress().getEmailAddressUnmasked());
	return person;
    }

}
