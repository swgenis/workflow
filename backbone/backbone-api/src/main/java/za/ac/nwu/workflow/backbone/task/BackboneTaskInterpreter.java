package za.ac.nwu.workflow.backbone.task;

public interface BackboneTaskInterpreter <T> {

	public String shortDescription(T task, String language);
	
	public String longDescription(T task, String language);
}
