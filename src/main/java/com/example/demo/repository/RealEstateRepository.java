package com.example.demo.repository;

import com.example.demo.model.RealEstate;
import com.example.demo.model.RealEstateCategory;
import com.example.demo.model.RealEstateType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {
    List<RealEstate> findRealEstateByTitleLike(String title);
    List<RealEstate> findRealEstateByCategory(RealEstateCategory category);
    List<RealEstate> findRealEstateByType(RealEstateType type);
}
