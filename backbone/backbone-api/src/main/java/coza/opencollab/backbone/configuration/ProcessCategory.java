package coza.opencollab.backbone.configuration;

import java.util.ArrayList;
import java.util.List;

public class ProcessCategory {

    private String name;

    private List<SubProcess> subProcesses;

    public ProcessCategory(String name) {
	super();
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<SubProcess> getSubProcesses() {
	if (subProcesses == null) {
	    subProcesses = new ArrayList<SubProcess>();
	}
	return subProcesses;
    }

}
