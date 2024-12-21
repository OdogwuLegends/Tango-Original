package com.tm30.tango.entities;

import com.tm30.tango.enums.MerchantRating;
import com.tm30.tango.enums.TransactionStatus;
import com.tm30.tango.enums.TransactionType;
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
@Table(name = "fuel_transaction")
public class FuelTransaction extends BaseEntity {
    @OneToOne
    @JoinColumn(nullable = false,name = "card_id")
    private Card card;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,2)")
    private BigDecimal amount = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @OneToOne
    @JoinColumn(nullable = false,name = "merchant_id")
    private Merchant merchant;

    @Enumerated(EnumType.STRING)
    private MerchantRating merchantRating;

    @OneToOne
    @JoinColumn(nullable = false,name = "fuel_id")
    private Fuel fuel;
}
