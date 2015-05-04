package za.ac.nwu.workflow.backbone.type.service.impl;

import za.ac.nwu.workflow.backbone.type.Type;
import za.ac.nwu.workflow.backbone.type.service.TypeService;

/**
 * 
 * @author SW Genis
 *
 */
public class TypeDataLoader {

    private TypeService typeService;

    public TypeDataLoader(TypeService typeService) {
	this.typeService = typeService;
    }

    public void loadData() throws Exception {
    }

    private void addType(String key, String category, String description) throws Exception {
	Type type = new Type();
	type.setKey(key);
	type.setCategory(category);
	type.setDescription(description);
	typeService.insertType(type);
    }

}
