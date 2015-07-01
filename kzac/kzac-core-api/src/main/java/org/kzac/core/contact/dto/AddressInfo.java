package org.kzac.core.contact.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.kzac.common.dto.IdEntityInfo;
import org.kzac.core.contact.infc.Address;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressInfo", propOrder = {
        "id", "typeKey", "stateKey", "name", "descr",
        "address", "postalAddress",
        "meta", "attributes", "_futureElements" })

public class AddressInfo 
    extends IdEntityInfo 
    implements Address, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String address;

    @XmlElement
    private PostalAddressInfo postalAddress;

    @XmlAnyElement
    private List<Object> _futureElements;


    /**
     *  Constructs a new AddressInfo.
     */
    public AddressInfo() {
    }

    /**
     *  Constructs a new AddressInfo from a Address
     * 
     *  @param address address to copy
     */
    public AddressInfo(Address address) {
        super(address);
        
        this.address = address.getAddress();
        if (address.getPostalAddress() != null) {
            this.postalAddress = new PostalAddressInfo(address.getPostalAddress());
        }                
    }

    
    @Override
    public String getAddress() {
        return (this.address);
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public PostalAddressInfo getPostalAddress() {
        return (this.postalAddress);
    }

    public void setPostalAddress(PostalAddressInfo postalAddress) {
        this.postalAddress = postalAddress;
    }
}
