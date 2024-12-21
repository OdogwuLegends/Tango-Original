package com.tm30.tango.entities;

import com.tm30.tango.enums.ChargeBackStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "chargeback")
public class ChargeBack extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "user_id")
    private User initiatedBy;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal amount = BigDecimal.ZERO;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "card_id")
    private Card card;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name = "fuel_transaction_id")
    private FuelTransaction transaction;

    private ChargeBackStatus status;

    private String reason;

    @OneToMany(fetch = FetchType.LAZY)
    private List<File> uploadedEvidence = new ArrayList<>();

}
