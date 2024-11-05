package com.microservice.user.iam.domain.model.commands;

import com.mindtrack.backend.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
