package coza.opencollab.backbone.data;

public interface DataLoaderCallback<T> {

    public void loadElement(T t) throws Exception;

}
