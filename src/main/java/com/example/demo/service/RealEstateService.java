package com.example.demo.service;

import com.example.demo.model.RealEstate;

import java.util.Collection;
import java.util.List;

public interface RealEstateService {
    RealEstate save(RealEstate realEstate);
    RealEstate delete(Long id);
    RealEstate findById(Long id);
    List<RealEstate> findByTitle(String title);
    List<RealEstate> findAll();

    void saveAll(Collection<RealEstate> realEstates);

    List<RealEstate> findByCategory(String category);
    List<RealEstate> findByType(String type);
}
