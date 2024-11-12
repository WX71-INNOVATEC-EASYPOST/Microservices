package com.microservice.daily.activities.domain.model.aggregates;

import com.microservice.daily.activities.domain.model.commands.CreateTaskCommand;
import com.microservice.daily.activities.domain.model.valueobjects.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private TaskStatus taskStatus;
    private LocalDate assignedDate;
    private Long assigneeId;

    @ManyToOne
    private DailyActivity dailyActivity;

    public Task(CreateTaskCommand command) {
        this.description = command.description();
        this.taskStatus = TaskStatus.valueOf(command.taskStatus().toUpperCase());
        this.assignedDate = command.assignedDate();
        this.assigneeId = command.assigneeId();
    }
}
