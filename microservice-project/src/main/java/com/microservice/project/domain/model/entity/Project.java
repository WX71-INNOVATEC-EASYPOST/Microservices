package com.microservice.project.domain.model.entity;

import com.microservice.project.domain.model.aggregates.Location;
import com.microservice.project.domain.model.commands.CreateProjectCommand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "access_code", nullable = false)
    private String accessCode;

    @Column(name = "company_profile_id", nullable = false)
    private Long companyProfileId;

    @Column(name = "total_budget", nullable = false)
    private Long totalBudget;

    @Column(name = "partial_budget", nullable = false)
    private Long partialBudget;

    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @ElementCollection
    @CollectionTable(name = "project_materials_ids", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "project_materials_ids", nullable = false)
    private List<Long> projectMaterialsIds;

    @Column(name = "request_id", nullable = false)
    private Long requestId;

    public Project(CreateProjectCommand command) {
        this.title = command.title();
        this.accessCode = command.accessCode();
        this.companyProfileId = command.companyProfileId();
        this.totalBudget = command.totalBudget();
        this.partialBudget = command.totalBudget();
        this.requestId = command.requestId();
        this.projectMaterialsIds = command.projectMaterialIds();
        this.locationId = command.locationId();
    }
}
