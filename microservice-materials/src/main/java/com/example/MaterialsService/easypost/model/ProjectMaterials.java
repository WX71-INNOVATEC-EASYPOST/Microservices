package com.example.MaterialsService.easypost.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project-materials")
public class ProjectMaterials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "project-id", nullable = false)
    private Long projectId;

    @Column(name = "material_id", nullable = false)
    private Long materialId;

    @Column(name = "amount", nullable = false)
    private double amount;

}
