package com.felipe.hotel.model.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    ONE_STAR("Una estrella"),
    TWO_STAR("Dos estrellas"),
    THREE_STAR("Tres estrellas"),
    FOUR_STAR("Cuatro estrellas"),
    FIVE_STAR("Cinco estrellas");

    private final String description;

}
