package com.example.PolesService.easypost.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pole")
public class Pole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "georeference_id", nullable = false)
    private GeoReference georeferenceId;
}