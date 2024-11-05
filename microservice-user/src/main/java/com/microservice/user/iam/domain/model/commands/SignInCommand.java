package com.microservice.user.iam.domain.model.commands;

public record SignInCommand(String username, String password) {
}
