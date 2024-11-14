package com.microservice.project.Interface.rest.transform;

import com.microservice.project.Interface.rest.resources.CreateProjectResource;
import com.microservice.project.domain.model.commands.CreateProjectCommand;

public class CreateProjectCommandFromResourceAssembler {
    public static CreateProjectCommand toCommandFromResource(CreateProjectResource projectResource) {
        return new CreateProjectCommand(
                projectResource.title(),
                projectResource.accessCode(),
                projectResource.companyProfileId(),
                projectResource.totalBudget(),
                projectResource.partialBudget(),
                projectResource.locationId(),
                projectResource.projectMaterialsIds(),
                projectResource.requestId()
        );
    }
}
