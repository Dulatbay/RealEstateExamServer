package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 2500)
    private String description;

    @Column(nullable = false)
    private Integer bed;

    @Column(nullable = false)
    private Integer bath;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String titlePicture;

    @Column(nullable = false)
    private boolean wife;

    @Enumerated(EnumType.STRING)
    private RealEstateType type;

    @Enumerated(EnumType.STRING)
    private RealEstateCategory category;

    @ElementCollection
    private Collection<String> pictures;


}
