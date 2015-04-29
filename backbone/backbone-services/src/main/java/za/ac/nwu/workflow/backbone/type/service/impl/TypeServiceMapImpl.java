package za.ac.nwu.workflow.backbone.type.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;

import za.ac.nwu.workflow.backbone.type.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;

@Default
public class TypeServiceMapImpl implements TypeService {

	private Map<String, Type> types = new HashMap<String, Type>();

	@PostConstruct
	public void initialize() throws Exception{
		TypeDataLoader dataLoader = new TypeDataLoader(this);
		try {
			dataLoader.loadData();
		} catch (Exception e) {
			throw new Exception("Unable to load data for TypeServiceMapImpl", e);
		}
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
