package org.kzac.common.search;

public class RelationalExpression implements Expression {

    public enum Operator {
	EQUALS, IN
    }

    public Argument leftArgument;

    public Operator operator;

    public Argument rightArgument;

    public RelationalExpression(Argument leftArgument, Operator operator, Argument rightArgument) {
	super();
	this.leftArgument = leftArgument;
	this.operator = operator;
	this.rightArgument = rightArgument;
    }
    
    public RelationalExpression(String field, Operator operator, String value) {
	super();
	this.leftArgument = new Field(field);
	this.operator = operator;
	this.rightArgument = new Value(value);
    }

    public Argument getLeftArgument() {
	return leftArgument;
    }

    public void setLeftArgument(Argument leftArgument) {
	this.leftArgument = leftArgument;
    }

    public Operator getOperator() {
	return operator;
    }

    public void setOperator(Operator operator) {
	this.operator = operator;
    }

    public Argument getRightArgument() {
	return rightArgument;
    }

    public void setRightArgument(Argument rightArgument) {
	this.rightArgument = rightArgument;
    }

    @Override
    public Boolean resolve(Object object) {
	
	String leftValue = leftArgument.resolve(object);
	String rightValue = rightArgument.resolve(object);
	
	if(operator.equals(Operator.EQUALS)){
	    if(leftValue.equals(rightValue)){
		return true;
	    }
	} else {
	    //TODO: Implement IN operator.
	    return false;
	}
	return false;
    }

}
