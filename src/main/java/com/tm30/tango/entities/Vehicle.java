package com.tm30.tango.entities;

import com.tm30.tango.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vehicle")
public class Vehicle extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String registrationNumber;

    private String plateNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "card_id")
    private Card card;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "user_id")
    private User driver;

    private boolean isActive;
}
