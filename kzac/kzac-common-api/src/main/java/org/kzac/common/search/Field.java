package org.kzac.common.search;

import org.apache.commons.beanutils.BeanUtils;

public class Field implements Argument {

    private String propertyName;

    public Field(String propertyName) {
	super();
	this.propertyName = propertyName;
    }

    @Override
    public String resolve(Object object) {
	try {
	    return BeanUtils.getSimpleProperty(object, propertyName);
	} catch (Exception e) {
	    // Ignore exceptions for now.
	}
	return "";
    }
}
