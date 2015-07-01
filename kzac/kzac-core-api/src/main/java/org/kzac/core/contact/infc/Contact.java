package org.kzac.core.contact.infc;

import org.kzac.common.infc.Relationship;

public interface Contact
    extends Relationship {

    
    /**
     *  Reference Uri.
     *
     *  @name Reference URI
     *  @required
     *  @readOnly 
     */
    public String getReferenceUri();

    /**
     *  Reference Id.
     *
     *  @name Reference Id
     *  @required
     *  @readOnly 
     */
    public String getReferenceId();

    /**
     *  The Address Id.
     *
     *  @name Address Id.
     *  @required
     *  @readOnly 
     */
    public String getAddressId();
}
