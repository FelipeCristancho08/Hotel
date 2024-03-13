package com.felipe.hotel.model.dto;

import com.felipe.hotel.model.entity.enums.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class HotelDTO {

    private Long id;
    private String name;
    private String department;
    private String city;
    private String direction;
    private String phoneNumber;
    private String description;
    private Category category;
    private Set<String> images;
    private Boolean parkingLot;
    private Boolean wifi;
    private float qualification;
}
