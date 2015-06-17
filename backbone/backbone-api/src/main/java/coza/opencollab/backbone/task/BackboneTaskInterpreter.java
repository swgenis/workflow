package coza.opencollab.backbone.task;

import java.util.Map;

public interface BackboneTaskInterpreter<T> {

    public T getFormObject(Map<String, Object> parms);

    public String shortDescription(T task, String language);

    public String longDescription(T task, String language);
}
