package za.ac.nwu.workflow.backbone.type.service.impl;

import za.ac.nwu.workflow.backbone.type.service.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;
import za.ac.nwu.workflow.backbone.type.service.TypeServiceConstants;

public class TypeDataLoader {

	private TypeService typeService;
	
	public TypeDataLoader(TypeService typeService){
		this.typeService = typeService;
	}

	public void loadData() throws Exception {
		addType(TypeServiceConstants.TYPE_LEAVE_ANNUAL, TypeServiceConstants.CATEGORY_LEAVE_TYPES);
		addType(TypeServiceConstants.TYPE_LEAVE_FAMILY, TypeServiceConstants.CATEGORY_LEAVE_TYPES);
		addType(TypeServiceConstants.TYPE_LEAVE_SICK, TypeServiceConstants.CATEGORY_LEAVE_TYPES);
	}

	private void addType(String key, String category) throws Exception {
		Type type = new Type();
		type.setKey(key);
		type.setCategory(category);
		typeService.insertType(type);
	}

}
