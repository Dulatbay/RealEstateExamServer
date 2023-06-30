package com.example.demo.dto;

import com.example.demo.model.RealEstateCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealEstateCardDto implements Serializable {
    // TODO: use this RealEstateCardDto
    private Long id;
    private String title;
    private String address;
    private Double price;
    private String titlePicture;
    private RealEstateCategory category;
}
