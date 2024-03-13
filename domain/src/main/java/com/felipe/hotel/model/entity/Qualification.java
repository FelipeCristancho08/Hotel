package com.felipe.hotel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Qualification {

    private Long id;
    private float qualification; //validar que sea entre 1 y 5
    private String comment;
}
