package com.microservice.project.Interface.rest.transform;

import com.microservice.project.Interface.rest.resources.ProjectResource;
import com.microservice.project.domain.model.commands.CreateProjectCommand;
import com.microservice.project.domain.model.entity.Project;

public class ProjectResourceFromEntityAssembler {
    public static ProjectResource toResourceFromEntity(Project project) {
        return new ProjectResource(
                project.getTitle(),
                project.getAccessCode(),
                project.getCompanyProfileId(),
                project.getTotalBudget(),
                project.getPartialBudget(),
                project.getLocationId(),
                project.getProjectMaterialsIds(),
                project.getRequestId()
        );
    }
}
