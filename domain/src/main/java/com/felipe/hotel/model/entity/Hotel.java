package com.felipe.hotel.model.entity;

import com.felipe.habitacion.model.entity.Room;
import com.felipe.hotel.model.entity.enums.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.felipe.comun.ArgumentValidator.validateLength;
import static com.felipe.comun.ArgumentValidator.validateRequired;
import static com.felipe.hotel.model.constant.ModelConstant.*;

@Getter
@Setter
public class Hotel {

    @Setter(AccessLevel.NONE)
    private Long id;
    @Setter(AccessLevel.NONE)
    private String name;
    @Setter(AccessLevel.NONE)
    private String department;
    @Setter(AccessLevel.NONE)
    private String city;
    @Setter(AccessLevel.NONE)
    private String direction;
    private String phoneNumber;
    private String description;
    private Category category;
    private Set<String> images;
    private Boolean parkingLot;
    private Boolean wifi;
    private List<Room> rooms;
    private List<Qualification> qualifications;
    private Double totalScores;

    public Hotel(Long id, String name, String department, String city, String direction, String phoneNumber,
                 String description, Category category, Set<String> images, Boolean parkingLot, Boolean wifi) {
        validateRequired(name, NAME_MUST_BE_OBLIGATORY);
        validateRequired(department, DEPARTMENT_MUST_BE_OBLIGATORY);
        validateRequired(city, CITY_MUST_BE_OBLIGATORY);
        validateRequired(direction, DIRECTION_MUST_BE_OBLIGATORY);
        validateRequired(phoneNumber, PHONE_NUMBER_MUST_BE_OBLIGATORY);
        validateRequired(category, CATEGORY_MUST_BE_OBLIGATORY);
        validateLength(description, MAX_LENGTH_DESCRIPTION, String.format(DESCRIPTION_MUST_BE_NO_MORE_THAN_255_CHARACTERS, MAX_LENGTH_DESCRIPTION));
        this.id = id;
        this.name = name;
        this.department = department;
        this.city = city;
        this.direction = direction;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.category = category;
        this.images = images;
        this.parkingLot = parkingLot;
        this.wifi = wifi;
        this.totalScores = 0.0;
        this.qualifications = new ArrayList<>();
        setDefaultFalse(this.parkingLot);
        setDefaultFalse(this.wifi);
    }

    private void setDefaultFalse(Boolean value){
        if(value == null){
            value = false;
        }
    }

    private void addRoom(Room room){
        rooms.add(room);
    }

    private void removeRoom(Room room){
        rooms.remove(room);
    }

    private void addQualification(Qualification qualification){
        qualifications.add(qualification);
        totalScores += qualification.getQualification();
    }

    private void removeQualification(Qualification qualification){
        qualifications.remove(qualification);
        totalScores -= qualification.getQualification();
    }

    public double calculateQualificationAverage(){
        return this.totalScores / this.qualifications.size();
    }
}
