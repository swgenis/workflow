package org.kzac.core.contact.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.kzac.common.dto.HasAttributesInfo;
import org.kzac.core.contact.infc.PostalAddress;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressInfo", propOrder = {
        "careOf", "mailstop", "streetAddressLine1", "streetAddressLine2",
        "localityName", "stateOrProvince", "countryCode", "postalCode",
        "attributes", "_futureElements" })

public class PostalAddressInfo 
    extends HasAttributesInfo 
    implements PostalAddress, Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String careOf;

    @XmlElement
    private String mailstop;

    @XmlElement
    private String streetAddressLine1;

    @XmlElement
    private String streetAddressLine2;

    @XmlElement
    private String localityName;

    @XmlElement
    private String stateOrProvince;

    @XmlElement
    private String countryCode;

    @XmlElement
    private String postalCode;

    @XmlAnyElement
    private List<Object> _futureElements;


    /**
     *  Constructs a new AddressInfo.
     */
    public PostalAddressInfo() {
    }

    /**
     *  Constructs a new AddressInfo from a Address
     * 
     *  @param address address to copy
     */
    public PostalAddressInfo(PostalAddress address) {
        super(address);
        
        this.careOf = address.getCareOf();
        this.mailstop = address.getMailstop();
        this.streetAddressLine1 = address.getStreetAddressLine1();
        this.streetAddressLine2 = address.getStreetAddressLine2();
        this.localityName = address.getLocalityName();
        this.stateOrProvince = address.getStateOrProvince();
        this.countryCode = address.getCountryCode();
        this.postalCode = address.getPostalCode();
    }

    
    @Override
    public String getCareOf() {
        return (this.careOf);
    }

    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }


    @Override
    public String getMailstop() {
        return (this.mailstop);
    }

    public void setMailstop(String mailstop) {
        this.mailstop = mailstop;
    }

    @Override
    public String getStreetAddressLine1() {
        return (this.streetAddressLine1);
    }

    public void setStreetAddressLine1(String streetAddressLine1) {
        this.streetAddressLine1 = streetAddressLine1;
    }

    @Override
    public String getStreetAddressLine2() {
        return (this.streetAddressLine2);
    }

    public void setStreetAddressLine2(String streetAddressLine2) {
        this.streetAddressLine2 = streetAddressLine2;
    }

    @Override
    public String getLocalityName() {
        return (this.localityName);
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    @Override
    public String getStateOrProvince() {
        return (this.stateOrProvince);
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    @Override
    public String getCountryCode() {
        return (this.countryCode);
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String getPostalCode() {
        return (this.postalCode);
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
