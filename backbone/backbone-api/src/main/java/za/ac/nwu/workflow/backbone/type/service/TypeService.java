package za.ac.nwu.workflow.backbone.type.service;

import java.util.List;

public interface TypeService {
	
	public Type getTypeByKey(String key);
	
	public List<Type> getTypesByCategory(String category) throws Exception;
	
	public void insertType(Type type) throws Exception;
	
	public void updateType(Type type) throws Exception;
	
	public void deleteTypeByKey(String key) throws Exception;

}
