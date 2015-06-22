package coza.opencollab.backbone.data;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import coza.opencollab.backbone.type.Type;
import coza.opencollab.backbone.type.service.TypeService;

@ApplicationScoped
public class DataLoaderFactory {

    @Inject
    private TypeService typeService;

    @Produces
    public JsonDataLoader<Type> getTypeDataLoader() {
	JsonDataLoader<Type> typeDataLoader = new JsonDataLoader<Type>(Type.class);
	typeDataLoader.setCallback(new DataLoaderCallback<Type>() {

	    @Override
	    public void loadElement(Type t) throws Exception {
		typeService.insertType(t);
	    }
	});

	return typeDataLoader;
    }
    
}
