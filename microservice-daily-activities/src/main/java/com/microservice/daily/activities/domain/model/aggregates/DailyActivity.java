package com.microservice.daily.activities.domain.model.aggregates;

import com.microservice.daily.activities.domain.model.commands.CreateDailyActivityCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class DailyActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;
    private String description;
    private LocalDate date;

    @OneToMany(mappedBy = "dailyActivity")
    private List<Task> tasks;

    public DailyActivity(CreateDailyActivityCommand command) {
        this.projectId = command.projectId();
        this.description = command.description();
        this.date = command.date();
        this.tasks = command.tasks();
    }
}
