package com.microservuce.daily_activites.domain.model.entity;

import com.microservuce.daily_activites.domain.model.commands.CreateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.commands.UpdateDailyActivityCommand;
import com.microservuce.daily_activites.domain.model.valuobjects.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daily_activity")
public class DailyActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "status", nullable = false)
    private Status status;

    public DailyActivity(CreateDailyActivityCommand command) {
        this.description = command.description();
        this.name = command.name();
        this.projectId = command.projectId();
        this.image = command.image();
        this.status = command.status();
    }

    public void updateDailyActivity(UpdateDailyActivityCommand command) {
        this.description = command.description();
        this.name = command.name();
        this.projectId = command.projectId();
        this.image = command.image();
        this.status = command.status();
    }
}
