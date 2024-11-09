package com.example.PolesService.easypost.repository;

import com.example.PolesService.easypost.model.GeoReference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoreferenceRepository extends JpaRepository<GeoReference, Long> {
}
