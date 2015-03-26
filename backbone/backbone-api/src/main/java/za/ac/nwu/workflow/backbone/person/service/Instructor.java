package za.ac.nwu.workflow.backbone.person.service;

import za.ac.nwu.workflow.backbone.Entity;


public class Instructor extends Entity {
	
	private Person person;
	
	private boolean mostSeniorInstructor;
	
	private int numberOfStudents;
	
	private int numberOfFemaleStudents;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public boolean isMostSeniorInstructor() {
		return mostSeniorInstructor;
	}

	public void setMostSeniorInstructor(boolean mostSeniorInstructor) {
		this.mostSeniorInstructor = mostSeniorInstructor;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public int getNumberOfFemaleStudents() {
		return numberOfFemaleStudents;
	}

	public void setNumberOfFemaleStudents(int numberOfFemaleStudents) {
		this.numberOfFemaleStudents = numberOfFemaleStudents;
	}
	
}
