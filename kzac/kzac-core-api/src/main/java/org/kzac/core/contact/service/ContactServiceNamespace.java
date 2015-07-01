package org.kzac.core.contact.service;

import org.kzac.common.constants.CommonServiceConstants;
import org.kzac.core.contact.dto.AddressInfo;
import org.kzac.core.contact.dto.ContactInfo;

/**
 * This class holds the constants used by the Contact service.
 *
 * @author tom
 */

public class ContactServiceNamespace {

    /**
     * Reference Object URI's
     */
    public static final String SERVICE_NAME_LOCAL_PART = "ContactService";
    public static final String NAMESPACE = CommonServiceConstants.REF_OBJECT_URI_GLOBAL_PREFIX + "contact";
    public static final String REF_OBJECT_URI_ADDRESS = NAMESPACE + "/" + AddressInfo.class.getSimpleName();
    public static final String REF_OBJECT_URI_CONTACT = NAMESPACE + "/" + ContactInfo.class.getSimpleName();
}
