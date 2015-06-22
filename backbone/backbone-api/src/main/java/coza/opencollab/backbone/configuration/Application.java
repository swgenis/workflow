package coza.opencollab.backbone.configuration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author SW Genis
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Application {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "category")
    private String category;

    @XmlElement(name = "type-source")
    private String typeSourceFile;

    @XmlElement(name = "url")
    private String url;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCategory() {
	return category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getTypeSourceFile() {
	return typeSourceFile;
    }

    public void setTypeSourceFile(String typeSourceFile) {
	this.typeSourceFile = typeSourceFile;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

}
