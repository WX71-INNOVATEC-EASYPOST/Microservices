package com.microservice.materials.domain.model.entity;

import com.microservice.materials.domain.model.commands.CreateMaterialCommand;
import com.microservice.materials.domain.model.commands.UpdateMaterialCommand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "materials")
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "cost", nullable = false)
    private double cost;

    public Materials(CreateMaterialCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.cost = command.cost();
    }

    public void updateMaterial(UpdateMaterialCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.cost = command.cost();
    }
}