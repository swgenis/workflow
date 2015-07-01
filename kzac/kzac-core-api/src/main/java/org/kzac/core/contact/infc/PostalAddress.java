package org.kzac.core.contact.infc;

import org.kzac.common.infc.HasAttributes;


/**
 *  A Postal Address used for an Address Type of "postal."
 *
 *  Formatting rules and required data for mailing typically vary by
 *  Country. Constraints may exist to determine what valid codes and
 *  names may be used for a given region.
 *
 *  Examples:
 *              Ron Hoffmann
 *              c/o Massachusetts Institute of Technology  (CareOf)
 *              Room E40-311                               (Mailstop)
 *              1 Amherst Street                           (Street 1)
 *              Cambridge MA 02139                         (Locality StateOrProvince PostalCode)
 *
 *              Peter Mogensen                        
 *              Niels Bohrs Alle 23, 1330                  (Street 1)
 *              Floor 13                                   (Mailstop)
 *              5230 Odense M                              (PostalCode Locality)
 *              Danmark                                    (CountryCode -> name)
 *
 *              Nildram Ltd
 *              Ardenham Court                             (Street 1)
 *              Oxford Road                                (Street 2)
 *              Aylesbury                                  (Locality)
 *              HP19 3EQ                                   (PostalCode)
 *              United Kingdom                             (CountryCode -> name)
 */

public interface PostalAddress
    extends HasAttributes {

    /**
     *  The care/of line. e.g. Massachusetts Institute of Technology
     *
     *  @name Care Of
     */
    public String getCareOf();

    /**
     *  The mail stop. e.g. Room E40-311
     *
     *  This is the part normally stuffed into the street address but
     *  has nothing to do with street navigation.
     *
     *  @name Mail Stop
     */
    public String getMailstop();

    /**
     *  The street address. e.g. 1 Amherst Street
     *
     *  @name Street Address 1
     */
    public String getStreetAddressLine1();

    /**
     *  The street address line 2 if applicable.
     *
     *  @name Street Address 2
     */
    public String getStreetAddressLine2();

    /**
     *  The name of the locality. e.g. Cambridge
     * 
     *  This is hierarchical in some places but this isn't dealing
     *  with that nuance. Some of the can be fudged into the second
     *  street address.
     *
     *  @name Locality Name
     */
    public String getLocalityName();

    /**
     *  The state/province name or code. e.g. MA
     *
     *  @name State Or Province
     */
    public String getStateOrProvince();

    /**
     *  The country code. e.g. USA
     *
     *  @name Country Code
     */
    public String getCountryCode();

    /**
     *  The postal code. e.g. 02139
     *
     *  @name Postal Code
     */
    public String getPostalCode();
}
