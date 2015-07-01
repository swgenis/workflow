package org.kzac.core.contact.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.kzac.common.dto.RelationshipInfo;
import org.kzac.core.contact.infc.Contact;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInfo", propOrder = {
        "id", "typeKey", "stateKey", 
        "effectiveDate", "expirationDate",
        "referenceUri", "referenceId", "addressId",
        "meta", "attributes", "_futureElements" })

public class ContactInfo 
    extends RelationshipInfo 
    implements Contact, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String referenceUri;

    @XmlElement
    private String referenceId;

    @XmlElement
    private String addressId;

    @XmlAnyElement
    private List<Object> _futureElements;


    /**
     *  Constructs a new ContactInfo.
     */
    public ContactInfo() {
    }


    /**
     *  Constructs a new ContactInfo from a Contact
     * 
     *  @param contact contact to copy
     */
    public ContactInfo(Contact contact) {
        super(contact);

        this.referenceUri = contact.getReferenceUri();
        this.referenceId = contact.getReferenceId();
        this.addressId = contact.getAddressId();
    }


    @Override
    public String getReferenceUri() {
        return (this.referenceUri);
    }


    public void setReferenceUri(String referenceUri) {
        this.referenceUri = referenceUri;
    }


    @Override
    public String getReferenceId() {
        return (this.referenceId);
    }


    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }


    @Override
    public String getAddressId() {
        return (this.addressId);
    }


    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
