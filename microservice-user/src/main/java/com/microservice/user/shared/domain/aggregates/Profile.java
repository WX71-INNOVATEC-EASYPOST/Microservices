package com.microservice.user.shared.domain.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@MappedSuperclass
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Getter
    @NotBlank
    @Column(nullable = false)
    private final String fullName;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private final String email;

    @Getter
    @NotBlank
    @Column(nullable = false)
    private final String phone;

    @Getter
    @Column(nullable = false)
    private final LocalDate birthDate;

    // Constructor
    public Profile(String fullName, String email, String phone, LocalDate birthDate) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    protected Profile() {
        this.fullName = null;
        this.email = null;
        this.phone = null;
        this.birthDate = null;
    }
}
