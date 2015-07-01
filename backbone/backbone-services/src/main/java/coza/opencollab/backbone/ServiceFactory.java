package coza.opencollab.backbone;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import coza.opencollab.backbone.configuration.service.ConfigurationService;
import coza.opencollab.backbone.organization.service.OrganizationService;
import coza.opencollab.backbone.qualifiers.MapService;
import coza.opencollab.backbone.type.service.TypeService;

@ApplicationScoped
public class ServiceFactory {

    @Inject
    @MapService
    OrganizationService organizationService;

    @Inject
    @MapService
    TypeService typeService;

    @Inject
    @MapService
    ConfigurationService configurationService;

    @Produces
    public OrganizationService produceOrganizationService() {
	return organizationService;
    }

    @Produces
    public TypeService produceTypeService() {
	return typeService;
    }

    @Produces
    public ConfigurationService produceConfigurationService() {
	return configurationService;
    }

}
