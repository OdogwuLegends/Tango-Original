package com.tm30.tango.entities;

import com.tm30.tango.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "merchant")
public class Merchant extends BaseEntity {
    private String fuelStationName;

    private String fuelStationAddress;

    private String latitude;

    private String longitude;

    private String managerName;

    private String contactEmail;

    private String contactPhoneNumber;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<FuelType> fuelTypes = new ArrayList<>();

    private boolean isActive;
}
