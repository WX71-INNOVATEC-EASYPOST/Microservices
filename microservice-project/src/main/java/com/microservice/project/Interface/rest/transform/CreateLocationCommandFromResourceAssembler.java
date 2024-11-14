package com.microservice.project.Interface.rest.transform;

import com.microservice.project.Interface.rest.resources.CreateLocationResource;
import com.microservice.project.Interface.rest.resources.CreateProjectResource;
import com.microservice.project.domain.model.commands.CreateLocationCommand;
import com.microservice.project.domain.model.commands.CreateProjectCommand;

public class CreateLocationCommandFromResourceAssembler {
    public static CreateLocationCommand toCommandFromResource(CreateLocationResource locationResource) {
        return new CreateLocationCommand(
                locationResource.department(),
                locationResource.province(),
                locationResource.district(),
                locationResource.locality(),
                locationResource.address(),
                locationResource.reference(),
                locationResource.projects(),
                locationResource.requestId()
        );
    }
}
