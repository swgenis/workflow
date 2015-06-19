package coza.opencollab.backbone.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

import coza.opencollab.backbone.ConfigurationProperty;

@Singleton
public class ConfigurationPropertyProducer {

    private Properties properties;

    @PostConstruct
    private void initializeProperties() throws IOException {
	InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
	properties = new Properties();

	if (inputStream != null) {
	    properties.load(inputStream);
	}

    }

    @Produces
    @ConfigurationProperty
    private String produceStringProperty(InjectionPoint injectionPoint) throws IOException {
	String key = injectionPoint.getAnnotated().getAnnotation(ConfigurationProperty.class).value();
	String defaultValue = injectionPoint.getAnnotated().getAnnotation(ConfigurationProperty.class).defaultValue();

	return properties.getProperty(key, defaultValue);
    }

    @Produces
    @ConfigurationProperty
    private boolean produceBooleanProperty(InjectionPoint injectionPoint) throws IOException {
	String key = injectionPoint.getAnnotated().getAnnotation(ConfigurationProperty.class).value();
	String defaultValue = injectionPoint.getAnnotated().getAnnotation(ConfigurationProperty.class).defaultValue();

	return Boolean.valueOf(properties.getProperty(key, defaultValue).toLowerCase());
    }
}
