package com.tm30.tango.entities;

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
@Table(name = "wallet")
public class Wallet extends BaseEntity {

    @OneToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User primaryUser;

    @Column(nullable = false,unique = true)
    private String accountNumber;

    private String pin;

    @OneToMany
    private List<Card> cards = new ArrayList<>();

    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal balance = BigDecimal.ZERO;

}
