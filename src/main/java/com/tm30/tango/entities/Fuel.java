package com.tm30.tango.entities;

import com.tm30.tango.enums.FuelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "fuel")
public class Fuel extends BaseEntity {

    @OneToOne
    @JoinColumn(nullable = false,name = "vehicle_id")
    private Vehicle vehicle;

    @Column(nullable = false)
    private double fuelQuantity;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal pricePerLitre = BigDecimal.ZERO;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal totalCost = BigDecimal.ZERO;

    @OneToOne
    @JoinColumn(name = "mileage_id")
    private Mileage mileage; // Why are we having mileage as an entity rather than save to type double for each fuel entity
}
