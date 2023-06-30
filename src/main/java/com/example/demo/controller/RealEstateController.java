package com.example.demo.controller;

import com.example.demo.model.RealEstate;
import com.example.demo.service.RealEstateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/real-estates")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RealEstateController {
    private RealEstateService realEstateService;
    // TODO: change request for dto
    @GetMapping("/get-all")
    private ResponseEntity<Collection<RealEstate>> getAll() {
        return ResponseEntity.ok(realEstateService.findAll());
    }
    @GetMapping("/category/{category}")
    private ResponseEntity<Collection<RealEstate>> getByCategory(@PathVariable String category) {
        System.out.println("REQUEST CATEGORY");
        return ResponseEntity.ok(realEstateService.findByCategory(category.toUpperCase()));
    }

    @GetMapping("/type/{type}")
    private ResponseEntity<Collection<RealEstate>> getByType(@PathVariable String type) {
        System.out.println("REQUEST TYPE");
        return ResponseEntity.ok(realEstateService.findByType(type.toUpperCase()));
    }

    @GetMapping("/{id}")
    private ResponseEntity<RealEstate> getById(@PathVariable Long id) {
        return ResponseEntity.ok(realEstateService.findById(id));
    }

}
