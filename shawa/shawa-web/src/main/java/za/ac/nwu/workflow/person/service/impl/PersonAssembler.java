package za.ac.nwu.workflow.person.service.impl;

import org.kuali.rice.kim.api.identity.entity.EntityDefault;
import org.kzac.common.dto.MetaInfo;
import org.kzac.core.person.dto.PersonInfo;

import coza.opencollab.backbone.person.service.impl.PersonServiceConstants;

public class PersonAssembler {
    
    public PersonInfo assemblePerson(EntityDefault entityDefault) {
	PersonInfo info = new PersonInfo();
        info.setId(entityDefault.getEntityId());
        info.setTypeKey(PersonServiceConstants.PERSON_TYPE_KEY);
        if (entityDefault.isActive()) {
            info.setStateKey(PersonServiceConstants.PERSON_TYPE_KEY);
        } else {
            info.setStateKey(PersonServiceConstants.PERSON_TYPE_KEY);
        }

        MetaInfo metaInfo = new MetaInfo();
        if (entityDefault.getName() == null) {
            info.setName("*** no default name  ***");
            metaInfo.setVersionInd("0");
        } else {
            info.setName(entityDefault.getName().getCompositeName());
            metaInfo.setVersionInd(entityDefault.getName().getVersionNumber() + "");
            if (entityDefault.getName().getNameChangedDate() != null) {
                metaInfo.setUpdateTime(entityDefault.getName().getNameChangedDate().toDate());
            }
        }
        info.setMeta(metaInfo);
        return info;
    }

}
