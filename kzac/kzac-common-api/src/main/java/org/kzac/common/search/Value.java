package org.kzac.common.search;

public class Value implements Argument {

    private String value;

    public Value(String value) {
	super();
	this.value = value;
    }

    @Override
    public String resolve(Object object) {
	return value;
    }

}
