package com.example.demo.service.impl;

import com.example.demo.model.RealEstate;
import com.example.demo.model.RealEstateCategory;
import com.example.demo.model.RealEstateType;
import com.example.demo.repository.RealEstateRepository;
import com.example.demo.service.RealEstateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Service
public class RealEstateServiceImpl implements RealEstateService {
    private final RealEstateRepository realEstateRepository;

    @Override
    public RealEstate save(RealEstate realEstate) {
        try {
            if (realEstate.getType() == null)
                realEstate.setType(RealEstateType.HOME);
            return realEstateRepository.save(realEstate);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public RealEstate delete(Long id) {
        try {
            return realEstateRepository.save(this.findById(id));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }

    @Override
    public RealEstate findById(Long id) {
        try {
            return realEstateRepository.findById(id).orElseThrow();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }

    @Override
    public List<RealEstate> findByTitle(String title) {
        try {
            return realEstateRepository.findRealEstateByTitleLike(title);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RealEstate> findAll() {
        try {
            return realEstateRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveAll(Collection<RealEstate> realEstates) {
        try {
            realEstateRepository.saveAll(realEstates);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<RealEstate> findByCategory(String category) {
        try {
            return realEstateRepository.findRealEstateByCategory(getCategory(category));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RealEstate> findByType(String type) {
        try {
            return realEstateRepository.findRealEstateByType(getType(type));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private RealEstateType getType(String type) {
        switch (type) {
            case "HOME" -> {
                return RealEstateType.HOME;
            }
            case "VILLA" -> {
                return RealEstateType.VILLA;
            }
            case "OFFICE" -> {
                return RealEstateType.OFFICE;
            }
            case "APARTMENT" -> {
                return RealEstateType.APARTMENT;
            }
            default -> {
                System.out.println("RealEstateType not found in service");
                return RealEstateType.HOME;
            }
        }
    }

    private RealEstateCategory getCategory(String category) {
        switch (category) {
            case "NEW" -> {
                return RealEstateCategory.NEW;
            }
            case "COMFORT" -> {
                return RealEstateCategory.COMFORT;
            }
            case "BEST" -> {
                return RealEstateCategory.BEST;
            }
            case "POPULAR" -> {
                return RealEstateCategory.POPULAR;
            }
            default -> {
                System.out.println("RealEstateCategory not found in service");
                return RealEstateCategory.NEW;
            }
        }
    }
}
