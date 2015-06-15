package coza.opencollab.backbone.type.service;

import java.util.List;

import coza.opencollab.backbone.type.Type;

/**
 * 
 * @author SW Genis
 * 
 */
public interface TypeService {

    /**
     * 
     * @param key
     * @return
     */
    public Type getTypeByKey(String key);

    /**
     * 
     * @param category
     * @return
     * @throws Exception
     */
    public List<Type> getTypesByCategory(String category) throws Exception;

    /**
     * 
     * @param type
     * @throws Exception
     */
    public void insertType(Type type) throws Exception;

    /**
     * 
     * @param type
     * @throws Exception
     */
    public void updateType(Type type) throws Exception;

    /**
     * 
     * @param key
     * @throws Exception
     */
    public void deleteTypeByKey(String key) throws Exception;

}
