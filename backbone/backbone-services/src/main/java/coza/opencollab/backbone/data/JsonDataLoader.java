package coza.opencollab.backbone.data;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author SW Genis
 * 
 */
public class JsonDataLoader<T> {

    private Class<T> targetClass;

    private DataLoaderCallback<T> callback;

    public JsonDataLoader(Class<T> targetClass) {
	this.targetClass = targetClass;
    }

    public void loadData(String file) throws Exception {
	loadData(file, callback);
    }

    public void loadData(String file, DataLoaderCallback<T> callback) throws Exception {
	InputStream is = JsonDataLoader.class.getClassLoader().getResourceAsStream(file);

	ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
	JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, targetClass);
	List<T> elements = mapper.readValue(is, type);

	// Execute callback
	for (T element : elements) {
	    callback.loadElement(element);
	}
    }

    public DataLoaderCallback<T> getCallback() {
	return callback;
    }

    public void setCallback(DataLoaderCallback<T> callback) {
	this.callback = callback;
    }

}
