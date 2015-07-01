package org.kzac.core.contact.infc;

import org.kzac.common.infc.IdEntity;


/**
 * An Address always displays the textual address via getAddress(). If
 * the Address is a postal address, then it also has the structure
 * returned by getPostalAddress() for management of the various
 * address components that roll up to the text available from
 * getAddress().
 */

public interface Address
    extends IdEntity {


    /**
     *  The complete address.
     *
     *  @name Address
     */
    public String getAddress();

    /**
     *  A postal address.
     *
     *  @name Postal Address
     */
    public PostalAddress getPostalAddress();
}
