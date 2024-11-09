package com.example.PolesService.easypost.repository;

import com.example.PolesService.easypost.model.GeoReference;
import com.example.PolesService.easypost.model.Pole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoleRepository extends JpaRepository<Pole, Long> {
    Pole findByGeoreferenceId(GeoReference georeference);
    Pole findByProjectId(Long projectId);
}
