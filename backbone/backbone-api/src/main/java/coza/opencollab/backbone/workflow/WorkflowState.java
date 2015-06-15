package coza.opencollab.backbone.workflow;

public enum WorkflowState {

    APPLIED("workflow.applied", "Applied"), APPROVED("workflow.approved", "Approved"), DENIED("workflow.denied",
	    "Denied"), CANCELED("workflow.canceled", "Canceled");

    private final String code;
    private final String description;

    WorkflowState(String code, String description) {
	this.code = code;
	this.description = description;
    }

    public String getCode() {
	return code;
    }

    public String getDescription() {
	return description;
    }

}
