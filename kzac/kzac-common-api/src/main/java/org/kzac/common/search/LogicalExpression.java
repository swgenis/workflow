package org.kzac.common.search;

public class LogicalExpression implements Expression {

    public enum Operator {
	AND, OR
    }

    public RelationalExpression leftExpression;

    public Operator operator;

    public RelationalExpression rightExpression;

    public LogicalExpression(RelationalExpression leftExpression, Operator operator,
	    RelationalExpression rightExpression) {
	super();
	this.leftExpression = leftExpression;
	this.operator = operator;
	this.rightExpression = rightExpression;
    }

    public RelationalExpression getLeftExpression() {
	return leftExpression;
    }

    public void setLeftExpression(RelationalExpression leftExpression) {
	this.leftExpression = leftExpression;
    }

    public Operator getOperator() {
	return operator;
    }

    public void setOperator(Operator operator) {
	this.operator = operator;
    }

    public RelationalExpression getRightExpression() {
	return rightExpression;
    }

    public void setRightExpression(RelationalExpression rightExpression) {
	this.rightExpression = rightExpression;
    }

    @Override
    public Boolean resolve(Object object) {
	
	boolean leftValue = leftExpression.resolve(object);
	boolean rightValue = rightExpression.resolve(object);
	
	if(operator.equals(Operator.AND)){
	    if(leftValue&&rightValue){
		return true;
	    }     
	} else {
	    if(leftValue||rightValue){
		return true;
	    } 
	}
	return false;
    }

}
