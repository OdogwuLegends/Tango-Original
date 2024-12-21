package com.tm30.tango.entities;

import com.tm30.tango.enums.CardStatus;
import com.tm30.tango.enums.LimitType;
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
@Table(name = "card")
public class Card extends BaseEntity {
    @ManyToOne
    @JoinColumn(nullable = false, name = "wallet_id")
    private Wallet wallet;

    @Column(nullable = false,unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String pin;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String cvv;


    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal balance = BigDecimal.ZERO;


    private boolean isActive;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    private long spendingLimit;

    @Enumerated(EnumType.STRING)
    private LimitType limitType;

    @OneToOne
    @JoinColumn(nullable = false, name = "created_by")
    private User createdBy;

    @OneToOne
    @JoinColumn(nullable = false, name = "created_for")
    private User createdFor;

    @OneToMany
    private List<Vehicle> vehicles = new ArrayList<>();
}
