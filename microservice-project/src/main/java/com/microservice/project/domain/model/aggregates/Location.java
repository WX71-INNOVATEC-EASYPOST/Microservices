package com.microservice.project.domain.model.aggregates;

import com.microservice.project.domain.model.commands.CreateLocationCommand;
import com.microservice.project.domain.model.entity.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "province", nullable = false)
    private String province;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "locality", nullable = false)
    private String locality;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "reference", nullable = false)
    private String reference;

    @OneToMany(mappedBy = "locationId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects;

    @Column(name = "requests_id", nullable = false)
    private Long requestId;

    public Location(CreateLocationCommand command) {
        this.department = command.department();
        this.province = command.province();
        this.district = command.district();
        this.locality = command.locality();
        this.address = command.address();
        this.reference = command.reference();
        this.projects = command.projects();
        this.requestId = command.requestId();
    }
}
