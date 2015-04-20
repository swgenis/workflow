package za.ac.nwu.workflow.backbone.type.service.impl;

import za.ac.nwu.workflow.backbone.type.service.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;
import za.ac.nwu.workflow.backbone.type.service.TypeServiceConstants;

public class TypeDataLoader {

	private TypeService typeService;

	public TypeDataLoader(TypeService typeService) {
		this.typeService = typeService;
	}

	public void loadData() throws Exception {
		addType(TypeServiceConstants.TYPE_LEAVE_ANNUAL,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Annual");
		addType(TypeServiceConstants.TYPE_LEAVE_ACCUMULATED,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Accumulated");
		addType(TypeServiceConstants.TYPE_LEAVE_FAMILYRESPONSIBILITY,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES,
				"Family Responsibility");
		addType(TypeServiceConstants.TYPE_LEAVE_SICK,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Sick");
		addType(TypeServiceConstants.TYPE_LEAVE_INJURYONDUTY,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Injury on Duty");
		addType(TypeServiceConstants.TYPE_LEAVE_STUDY,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Study");
		addType(TypeServiceConstants.TYPE_LEAVE_MATERNITY,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Maternity");
		addType(TypeServiceConstants.TYPE_LEAVE_UNPAID,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Unpaid");
		addType(TypeServiceConstants.TYPE_LEAVE_SPECIAL,
				TypeServiceConstants.CATEGORY_LEAVE_TYPES, "Special");
	}

	private void addType(String key, String category, String description)
			throws Exception {
		Type type = new Type();
		type.setKey(key);
		type.setCategory(category);
		type.setDescription(description);
		typeService.insertType(type);
	}

}
