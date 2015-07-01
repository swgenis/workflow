package org.kzac.common.search;

public class Criteria {

    public Expression where;

    public Expression getWhere() {
	return where;
    }

    public void setWhere(Expression where) {
	this.where = where;
    }

}
