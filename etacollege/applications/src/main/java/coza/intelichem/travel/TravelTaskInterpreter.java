package coza.intelichem.travel;

import java.util.Map;

import coza.opencollab.backbone.task.BackboneTaskInterpreter;

public class TravelTaskInterpreter implements BackboneTaskInterpreter<TravelRequest> {
    
    @Override
    public TravelRequest getFormObject(Map<String, Object> parms) {
	return (TravelRequest) parms.get("travelRequest");
    }

    @Override
    public String shortDescription(TravelRequest task, String language) {
	StringBuilder sb = new StringBuilder();
	sb.append(task.getApplicantId());
	sb.append(" - Travel Request ");
	return sb.toString();
    }

    @Override
    public String longDescription(TravelRequest task, String language) {
	return shortDescription(task, language);
    }

}
