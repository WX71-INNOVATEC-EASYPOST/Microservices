package com.example.PolesService.easypost.service;

import com.example.PolesService.easypost.model.GeoReference;
import com.example.PolesService.easypost.model.Pole;

import java.util.List;

public interface PoleService {
    Pole createPole(Pole pole);
    List<Pole> getAllPoles();
    Pole getPoleById(Long id);
    Pole getPoleByGeoreferenceId(Long geoReference);
    Pole getPoleByProjectId(Long projectId);
}
