package com.example.PolesService.easypost.service.Impl;

import com.example.PolesService.easypost.model.GeoReference;
import com.example.PolesService.easypost.model.Pole;
import com.example.PolesService.easypost.repository.GeoreferenceRepository;
import com.example.PolesService.easypost.repository.PoleRepository;
import com.example.PolesService.easypost.service.PoleService;
import com.example.PolesService.shared.exception.ResourceNotFoundException;
import com.example.PolesService.shared.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoleServiceImpl implements PoleService {
    @Autowired
    private PoleRepository poleRepository;
    @Autowired
    private GeoreferenceRepository geoReferenceRepository;

    @Override
    public Pole createPole(Pole pole) {
        return poleRepository.save(pole);
    }

    @Override
    public List<Pole> getAllPoles() {
        return poleRepository.findAll();
    }

    @Override
    public Pole getPoleById(Long id) {
        return poleRepository.findById(id).orElseThrow(()-> new ValidationException("Pole not found!"));
    }

    @Override
    public Pole getPoleByGeoreferenceId(Long georeferenceId) {
        GeoReference georeference = geoReferenceRepository.findById(georeferenceId)
                .orElseThrow(() -> new ResourceNotFoundException("GeoReference not found with id " + georeferenceId));
        return poleRepository.findByGeoreferenceId(georeference);
    }

    @Override
    public Pole getPoleByProjectId(Long projectId) {
        return poleRepository.findByProjectId(projectId);
    }
}
