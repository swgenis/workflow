package za.ac.nwu.workflow.backbone.type.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import za.ac.nwu.workflow.backbone.type.service.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;

public class TypeServiceMapImpl implements TypeService {

	private Map<String, Type> types = new HashMap<String, Type>();

	@PostConstruct
	public void initialize(){
		addType("leave.type.annual", "leave.type.category");
		addType("leave.type.family", "leave.type.category");
		addType("leave.type.sick", "leave.type.category");
	}
	
	private void addType(String key, String category) {
		Type type = new Type();
		type.setKey(key);
		type.setCategory(category);
		types.put(key, type);
	}
	
	@Override
	public Type getTypeByKey(String key) {
		if (types.containsKey(key)) {
			return types.get(key);
		}
		return null;
	}

	@Override
	public List<Type> getTypesByCategory(String category) throws Exception {
		if (category == null) {
			throw new Exception("Category is null");
		}

		List<Type> returnTypes = new ArrayList<Type>();
		for (Type type : types.values()) {
			if (category.equals(type.getCategory())) {
				returnTypes.add(type);
			}
		}
		return returnTypes;
	}

	@Override
	public void insertType(Type type) throws Exception {
		if (types.containsKey(type.getKey())) {
			throw new Exception("Type already exists for key " + type.getKey());
		}
		types.put(type.getKey(), type);
	}

	@Override
	public void updateType(Type type) throws Exception {
		if (!types.containsKey(type.getKey())) {
			throw new Exception("Type does not exist for key " + type.getKey());
		}
		types.put(type.getKey(), type);
	}

	@Override
	public void deleteTypeByKey(String key) throws Exception {
		if (!types.containsKey(key)) {
			throw new Exception("Type does not exist for key " + key);
		}
		types.remove(key);
	}

	public Map<String, Type> getTypes() {
		return types;
	}

	public void setTypes(Map<String, Type> types) {
		this.types = types;
	}

}
