package org.kzac.core.person.service;

import org.kzac.common.constants.CommonServiceConstants;
import org.kzac.core.person.dto.PersonInfo;

/**
 * This class holds the constants used by the Person service
 */
public class PersonServiceNamespace {
    public static final String NAMESPACE = CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "person";
    public static final String REF_OBJECT_URI_PERSON = NAMESPACE + "/" + PersonInfo.class.getSimpleName();
    public static final String SERVICE_NAME_LOCAL_PART = "PersonService";
}
