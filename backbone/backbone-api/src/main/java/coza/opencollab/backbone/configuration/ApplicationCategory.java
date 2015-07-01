package coza.opencollab.backbone.configuration;

import java.util.ArrayList;
import java.util.List;

public class ApplicationCategory {

    private String name;

    private List<Application> applications;

    public ApplicationCategory(String name) {
	super();
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Application> getApplications() {
	if (applications == null) {
	    applications = new ArrayList<Application>();
	}
	return applications;
    }

}
