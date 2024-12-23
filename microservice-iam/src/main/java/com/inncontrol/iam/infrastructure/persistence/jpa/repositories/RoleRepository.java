package com.inncontrol.iam.infrastructure.persistence.jpa.repositories;


import com.inncontrol.iam.domain.model.entities.Role;
import com.inncontrol.iam.domain.model.valueobjects.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
    boolean existsByName(Roles name);
}
